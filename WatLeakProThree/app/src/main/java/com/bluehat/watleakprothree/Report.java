package com.bluehat.watleakprothree;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Report extends AppCompatActivity implements View.OnClickListener {

    EditText jaDetails;
    TextView jaLocation;
    ImageView jaComImage;
    Button jabtnTakePhoto, jabtnChoosePhoto, jabtnSubmit;
    private String complaintDatatext, ownerId;
    AlertDialog.Builder builder;
    SharedPreferences InReport;


    //Varibale for camera and photo operations
    private static final String IMAGE_DIRECTORY_NAME = "watcamera";
    private static String autofilename;
    private String photoname;
    private static final int MEDIA_TYPE_IMAGE = 1;
    private final int IMG_REQUEST = 1;
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    private Uri path;
    private Bitmap bitmap;



    private static String street, Bigcity, gpsArea, gpsLonStr, gpsLatStr;

    private double gpsLon, gpsLat;
    LocationManager locationManager;
    LocationListener locationListener;

    private int cnt = 1;








  //private String UploadUrl = "http://192.168.64.1:82/water/phoneOp/submitfromphonenew.php";
    private String UploadUrl ="http://192.168.43.96:82/water/phoneOp/submitfromphonetb.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        gpsLonStr = "no";
        gpsLatStr = "no";
        gpsArea ="no";
        Bigcity ="no";
        street = "no";

        jaDetails = (EditText) findViewById(R.id.etCom_Details);
        jaLocation = (TextView) findViewById(R.id.txtCom_GPS);
        jaComImage = (ImageView) findViewById(R.id.imgCom_Photo);
        jabtnTakePhoto = (Button) findViewById(R.id.btnCapture);
        jabtnChoosePhoto = (Button) findViewById(R.id.btnChoose);
        jabtnSubmit = (Button) findViewById(R.id.btnCom_Submit);


        InReport = getSharedPreferences("distData", MODE_PRIVATE);
        ownerId = InReport.getString("userID", "");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        builder = new AlertDialog.Builder(Report.this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        jabtnSubmit.setOnClickListener(this);
        jabtnTakePhoto.setOnClickListener(this);
        jabtnChoosePhoto.setOnClickListener(this);

        do {
            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    jaLocation.setText(hereLocation(location.getLatitude(), location.getLongitude()));
                    gpsArea = hereLocation(location.getLatitude(), location.getLongitude());
                    gpsLat = location.getLatitude();
                    gpsLon = location.getLongitude();
                    jaLocation.setText(gpsArea);
                    gpsLatStr = Double.toString(gpsLat);
                    gpsLonStr = Double.toString(gpsLon);

                    if(gpsArea.isEmpty())
                    {
                        gpsLonStr = "no";
                        gpsLatStr = "no";
                        gpsArea ="no";
                        Bigcity ="no";
                        street = "no";
                    }

                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
            };
            configureButton();


            cnt++;
        } while (gpsArea.isEmpty());

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMG_REQUEST && resultCode == RESULT_OK && data != null) {
            path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                jaComImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            previewCapturedImage();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCapture:
                captureImage();
                break;
            case R.id.btnChoose:
                chooseImage();
                break;
            case R.id.btnCom_Submit:


                complaintDatatext = jaDetails.getText().toString();
                if (!complaintDatatext.isEmpty() || !complaintDatatext.matches(".*")) {
                    uploadImage();
                } else {
                    displayAlert("Please provide a brief description", null);

                }
                break;
            case R.id.txtCom_GPS:
                configureButton();
                jaLocation.setText(gpsArea);
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent3 = new Intent();
        if (item.getItemId() == R.id.logout) {
            SharedPreferences.Editor editor = InReport.edit();
            editor.putString("userID", "0000");
            editor.putString("userPass", "0000");
            editor.putString("state", "0000");
            editor.commit();
            Toast.makeText(getApplicationContext(), "Loging out", Toast.LENGTH_SHORT).show();
            intent3 = new Intent(getApplicationContext(), Login.class);

            startActivity(intent3);
        } else if (item.getItemId() == R.id.about) {
            Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void displayAlert(final String message, String signal) {

        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }





    //CAMERA METHODS
    private void previewCapturedImage() {
        jaComImage.setVisibility(View.VISIBLE);
        BitmapFactory.Options options = new BitmapFactory.Options();
        //downsizing image as it throws OutofMemeory Exception for lager images

        options.inSampleSize = 8;

        // final Bitmap bitmap = BitmapFactory.decodeFile(path.getPath(), options);
        bitmap = BitmapFactory.decodeFile(path.getPath(), options);

        jaComImage.setImageBitmap(bitmap);

    }

    private void uploadImage() {




        StringRequest stringRequest = new StringRequest(Request.Method.POST, UploadUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String Response = jsonObject.getString("response");
                    Toast.makeText(Report.this,Response, Toast.LENGTH_LONG).show();
                    jaComImage.setImageResource(0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Report.this,"Error", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("image", imagToString(bitmap));
                params.put("detail",complaintDatatext);
                params.put("owner",ownerId);


                    params.put("longgps",gpsLonStr);
                    params.put("latigps",gpsLatStr);
                    params.put("gpsCoordinate",gpsArea);
                    params.put("gpsCity",Bigcity);
                    params.put("gpsAddress",street);


                return params;
            }
        };
        MySingleton.getmInstance(Report.this).addToRequestque(stringRequest);


    }

    private void captureImage() {
        Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        path = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

        intent2.putExtra(MediaStore.EXTRA_OUTPUT, path);

        //start the image intent


        startActivityForResult(intent2, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);


    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMG_REQUEST);
    }

    private String imagToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imaBytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imaBytes, Base64.DEFAULT);
    }


    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutPutMediaFile(type));
    }


    private static File getOutPutMediaFile(int type) {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), IMAGE_DIRECTORY_NAME);
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }


        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());

        File mediafile = null;

        if (type == MEDIA_TYPE_IMAGE) {
            mediafile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timestamp + ".jpg");
        }

        autofilename = mediafile.getName().toString();
        return mediafile;

    }



    //GPS METHODS


    private void configureButton() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
    }


    public String hereLocation (double lat,double lon) {
        String curCity = "";
        // String feName = "";
        gpsLon = lon;
        gpsLat = lat;

        Geocoder geocoder = new Geocoder(Report.this, Locale.getDefault());
        List<Address> addressList;

        try {
            addressList = geocoder.getFromLocation(lat, lon, 1);

            if (addressList.size() > 0) {

                String address = addressList.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                String city = addressList.get(0).getLocality();
                curCity =  city + ", \t " + address;

                Bigcity = city;
                street = address;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




        return curCity;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 10:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    configureButton();
                return;
        }
    }
}
