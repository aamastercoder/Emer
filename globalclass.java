package com.ash.emer.emergency;

/**
 * Created by ashish on 8/29/2015.
 */
import android.app.Application;

public class globalclass extends Application{

    private String name="abc";
    private String email;


    public String getName() {

        return name;
    }

    public void setName(String aName) {

        name = aName;

    }

    /*public String getEmail() {

        return email;
    }

    public void setEmail(String aEmail) {

        email = aEmail;
    }
*/
}