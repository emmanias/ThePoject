package com.bluehat.watleakprothree;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    EditText etLogUserid,etLogUserpass;
    TextView txtLogReg,txtLogPassforgot,txtLogEmergency;
    Button btnLogin;
    String jaLogUserid,jaLogUserpass;
    AlertDialog.Builder builder;
    SharedPreferences sharedPreferences;
    String commondata = "distData";

    String login_url = "http://192.168.64.1:82/pilotpro/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogUserid = (EditText) findViewById(R.id.etLogin_user);
        etLogUserpass = (EditText) findViewById(R.id.etLogin_pass);
        txtLogPassforgot = (TextView) findViewById(R.id.txtLogin_forgotpass);
        txtLogEmergency = (TextView) findViewById(R.id.txtLogin_emergency);
        txtLogReg = (TextView) findViewById(R.id.txtLogin_register);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        builder = new AlertDialog.Builder(Login.this);

        sharedPreferences = getSharedPreferences(commondata, Context.MODE_PRIVATE);

        txtLogReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Login.this,Registration.class);
                startActivity(intentReg);

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jaLogUserid = etLogUserid.getText().toString();
                jaLogUserpass = etLogUserpass.getText().toString();

                if(jaLogUserid.isEmpty() || jaLogUserpass.isEmpty())
                {
                    builder.setTitle("Something went wrong");
                   // builder.setMessage("Please fill all the fields...");
                    displayAlert("Enter a valid Email or Phone number and a valid password...",null);
                }

                else
                {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, login_url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONArray jsonArray = new JSONArray(response);
                                        JSONObject jsonObject = jsonArray.getJSONObject(0);
                                        String code = jsonObject.getString("code");
                                        if(code.equals("login_failed"))
                                        {
                                            builder.setTitle("Login Error");
                                            displayAlert(jsonObject.getString(code),null);
                                        }
                                        else
                                        {
                                            Intent intent = new Intent(Login.this,Report.class);
                                            Bundle bundle = new Bundle();

                                            //shared preferences
                                            SharedPreferences.Editor editor = sharedPreferences.edit();
                                            editor.putString("userID",jaLogUserid);
                                            editor.putString("userPass",jaLogUserpass);
                                            editor.putString("state","one");
                                            editor.commit();

                                            bundle.putString("name",jsonObject.getString("name"));
                                            intent.putExtras(bundle);
                                            startActivity(intent);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Login.this,"Error",Toast.LENGTH_LONG).show();
                            error.printStackTrace();

                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<String, String>();
                            params.put("user_email",jaLogUserid);
                            params.put("user_pass",jaLogUserpass);
                            return params;
                        }
                    };

                    MySingleton.getmInstance(Login.this).addToRequestque(stringRequest);
                }


            }
        });






    }




    public void displayAlert(final String message,String Signal)
    {
        builder.setMessage(message);

        if(Signal.equals("first")) {
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setPositiveButton("Clear", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    etLogUserid.setText("");
                    etLogUserpass.setText("");

                }
            });

        }

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }




}
