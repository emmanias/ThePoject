package com.bluehat.watleakprothree;

/**
 * Created by Justin on 7/12/2017.
 */

public class WatValidator {


    //login Screen
    private String userLogID;
    private String userLogPass;

    private Boolean userLogID_State;
    private Boolean getUserLogPass_State;


    //Registration
    private String varRegFname;
    private String varRegLname;
    private String varRegPhone;
    private String varRegEmail;
    private String varRegPassword;

    //General
    private String message;


    public WatValidator(String varRegFname, String varRegLname, String varRegPhone, String varRegEmail, String varRegPassword) {
        this.varRegFname = varRegFname;
        this.varRegLname = varRegLname;
        this.varRegPhone = varRegPhone;
        this.varRegEmail = varRegEmail;
        this.varRegPassword = varRegPassword;
    }


    //getters


    public String getVarRegFname() {
        return varRegFname;
    }

    public String getVarRegLname() {
        return varRegLname;
    }

    public String getVarRegPhone() {
        return varRegPhone;
    }

    public String getVarRegEmail() {
        return varRegEmail;
    }

    public String getVarRegPassword() {
        return varRegPassword;
    }

    //Methods
    private void detailIn()
    {
        //Clean data before analyzing;
        dataClean();

        if(varRegFname.matches(" .*"))
        {
            message ="Please provide your first name";
        }
        else if(varRegFname.matches("[A-Z][a-zA-Z]{1,15}"))
        {
            if(varRegLname.matches(" .*"))
            {
                message = "Please provide your last name";
            }
            else if(varRegLname.matches("[A-Z][a-zA-Z]{1,15}"))
            {
                //mo
                if(varRegPhone.matches(" .*"))
                {
                    message = "Please provide your phone number";
                }
                else if(varRegPhone.matches("[\\d]{10}"))
                {
                    if(varRegEmail.matches(" .*"))
                    {
                        message = "Please provide an email address";
                    }
                    else if(android.util.Patterns.EMAIL_ADDRESS.matcher(varRegEmail).matches())
                    {
                        if(varRegPassword.matches(" .*"))
                        {
                            message ="Please provide a password";
                        }
                        else if(varRegPassword.length() >= 8  )
                        {
                            //statepass ///final
                            message = "good";
                        }
                        else{
                            message = "The pass word you entered is in valid and must contain eight or more characters";
                        }
                    }
                    else
                        {
                            message="The email you entered is invlaid";
                        }
                }
                else
                    {
                        message = "The phone number you entered is invalid";
                    }
            }
            else
                {
                    message = "The last name you entered is invalid";
                }
        }
        else{
            message = "The first name you entered is invalid";
        }




    }


    public String getMessage() {
        detailIn();
        return message;
    }

    private static String upperCaseFirst(String value) {


        // Convert String to char array.
        char[] array = value.toCharArray();
        // Modify first element in array.
        array[0] = Character.toUpperCase(array[0]);
        // Return string.
        return new String(array);
    }



    private void dataClean()
    {
        if(!varRegFname.trim().isEmpty() || !varRegLname.trim().isEmpty())
        {
            varRegFname = upperCaseFirst(varRegFname.trim());
            varRegLname = upperCaseFirst(varRegLname.trim());
        }

        varRegPhone = varRegPhone.trim();
    }
}
