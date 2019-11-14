package com.example.twitterapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        //Initialization code
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("7c4e7675d03e0fbb37e086431eadbd7101f78ecb")
                .clientKey("136aa2fdecf73cf737b354583375ab1242c8097d")
                .server("http://54.245.154.114:80/parse")
                .build()
        );


        ParseObject parseObject = new ParseObject("ExampleObject");
        parseObject.put("names","Krishna");
        parseObject.put("age","99");
        parseObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null) {
                    Log.i("Krishna Ji Connection :", "Success");
                }
                else{
                    Log.i("Krishna Ji Connection :","Failed" + e.toString());
                }

            }
        });

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(false);
        ParseACL.setDefaultACL(defaultACL,true);



        ParseAnalytics.trackAppOpenedInBackground(getIntent());


    }
}
