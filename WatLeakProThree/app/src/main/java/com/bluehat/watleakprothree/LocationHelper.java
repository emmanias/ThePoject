package com.bluehat.watleakprothree;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Justin on 7/17/2017.
 */

public class LocationHelper extends AppCompatActivity {


    private LocationManager locationManager;
    private LocationListener locationListener;
    private Context mtx;
    private String theCordinates,theCity,theAddress;
    private double colong,colati;


    public LocationHelper(LocationManager locationManager, LocationListener locationListener, Context mtx) {
        this.locationManager = locationManager;
        this.locationListener = locationListener;
        this.mtx = mtx;
    }

    public LocationHelper(Context mtx) {
        this.mtx = mtx;
    }

    private String makeLoc() {


        locationManager = (LocationManager) mtx.getSystemService(LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                theCordinates = herelocation(location.getLongitude(), location.getLatitude());
                colong = location.getLongitude();
                colati = location.getAltitude();
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

        bou();
        //locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);




        return theCordinates;
    }

    private String herelocation(double lon, double lat)
    {
        String gps = "";
        String address = "";
        String city = "";


        Geocoder geocoder = new Geocoder(mtx, Locale.getDefault());
        List<Address> addressList;

        try {
            addressList = geocoder.getFromLocation(lat, lon, 1);

            if (addressList.size() > 0) {

                theAddress= address = addressList.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                theCity = city = addressList.get(0).getLocality();
                gps = city  + " ,\t" + address ;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }



        return  gps;
    }



    public String getAddresLocationDetail()
    {

        makeLoc();
        return theCordinates;
    }


    public String getTheCordinates() {
        return theCordinates;
    }

    public String getTheCity() {
        return theCity;
    }

    public String getTheAddress() {
        return theAddress;
    }

    public double getColong() {
        return colong;
    }

    public double getColati() {
        return colati;
    }

    public void bou(){
        if (ActivityCompat.checkSelfPermission(mtx, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mtx, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET
                }, 10);
            }
            return;
        }
        else{
            locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
        }

    }


}


