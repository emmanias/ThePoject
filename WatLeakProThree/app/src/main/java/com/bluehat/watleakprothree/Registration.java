package com.bluehat.watleakprothree;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class Registration extends AppCompatActivity {


    EditText etRegFirstname, etRegLastname, etRegPhonenumer, etRegEmail, etRegPass;
    Button btnRegRegister;
    RadioGroup rggrpRegGenger;
    RadioButton rdRegM,rdRegF;

    String jaRegFirstname, jaRegLastname, jaRegPhonenumber, jaRegEmail, jaRegPass;
    String jaReggender;

    AlertDialog.Builder builder;
    View.OnFocusChangeListener listener;
   // String reg_url = "http://192.168.64.1:82/water/phoneOp/register.php";
   // String reg_url = "http://192.168.64.1:82/pilotpro/login.php";
   String reg_url = "http://192.168.64.1:82/water/phoneOp/register.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etRegFirstname = (EditText) findViewById(R.id.etReg_Firstname);
        etRegLastname = (EditText) findViewById(R.id.etReg_Lastname);
        etRegPhonenumer = (EditText) findViewById(R.id.etReg_Phonenumber);
        etRegEmail = (EditText) findViewById(R.id.etReg_Email);
        etRegPass = (EditText) findViewById(R.id.etReg_Pass);
        btnRegRegister = (Button) findViewById(R.id.btnReg_Register);
        rggrpRegGenger = (RadioGroup) findViewById(R.id.rdgrpGender);
        rdRegM = (RadioButton) findViewById(R.id.rdReg_Male);
        rdRegF = (RadioButton) findViewById(R.id.rdReg_Female);


        builder = new AlertDialog.Builder(Registration.this);

/*
        rggrpRegGenger.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (radioGroup.getId())
                {
                    case R.id.rdReg_Male:
                        jaReggender = "Male";
                        break;
                    case R.id.rdReg_Female:
                        jaReggender = "Female";
                        break;
                }
            }
        });

*/






        btnRegRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jaRegFirstname = etRegFirstname.getText().toString();
                jaRegLastname = etRegLastname.getText().toString();
                jaRegPhonenumber = etRegPhonenumer.getText().toString();
                jaRegEmail = etRegEmail.getText().toString();
                jaRegPass = etRegPass.getText().toString();


                WatValidator watValidatorReg = new WatValidator(jaRegFirstname,jaRegLastname,jaRegPhonenumber,jaRegEmail,jaRegPass);


                if (jaRegFirstname.isEmpty() || jaRegLastname.isEmpty() || jaRegPhonenumber.isEmpty() || jaRegEmail.isEmpty() || jaRegPass.isEmpty()) {

                    builder.setTitle("Something went wrong...");
                    builder.setMessage("Please fill all fields");
                    displayAlert("input_error");



               }


                else if(watValidatorReg.getMessage() == "good") {


                    jaRegFirstname = watValidatorReg.getVarRegFname();
                    jaRegLastname = watValidatorReg.getVarRegLname();
                    jaRegPhonenumber = watValidatorReg.getVarRegPhone();
                    jaRegEmail = watValidatorReg.getVarRegEmail();
                    jaRegPass = watValidatorReg.getVarRegPassword();

//
//                    jaRegFirstname = "testuser";
//                    jaRegLastname = "testus1ern";
//                    jaRegPhonenumber = "test2usern";
//                    jaRegEmail = "testus3ern";
//                    jaRegPass = "test4usern";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, reg_url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                JSONObject jsonObject = jsonArray.getJSONObject(0);
                                String code = jsonObject.getString("code");
                                /*String message = jsonObject.getString("message");*/
                                builder.setTitle("Sever Response...");
                                builder.setMessage(code);
                                displayAlert(code);

                                //start activity
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(Registration.this,"Error",Toast.LENGTH_LONG).show();
                            error.printStackTrace();
                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String ,String> params = new HashMap<String, String>();
                            params.put("first_name",jaRegFirstname);
                            params.put("last_name",jaRegLastname);

                            params.put("user_email",jaRegEmail);
                            params.put("user_pass",jaRegPass);
                            params.put("user_phone",jaRegPhonenumber);

                            return params;
                        }
                    };

                    MySingleton.getmInstance(Registration.this).addToRequestque(stringRequest);


                }

                else {

                    builder.setTitle("Something went wrong...");
                    builder.setMessage(watValidatorReg.getMessage());
                    displayAlert("input_error");
                }







            }
        });
    }


    public void displayAlert(final String code) {
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (code.equals("input_error")) {
                    etRegFirstname.setText("");
                    etRegLastname.setText("");
                    etRegPhonenumer.setText("");
                    etRegEmail.setText("");
                    etRegPass.setText("");
                }
                else if(code.equals("reg_success"))
                {
                    finish();
                }
                else if(code.equals("reg_failed"))
                {
                    etRegFirstname.setText("");
                    etRegLastname.setText("");
                    etRegPhonenumer.setText("");
                    etRegEmail.setText("");
                    etRegPass.setText("");
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}
