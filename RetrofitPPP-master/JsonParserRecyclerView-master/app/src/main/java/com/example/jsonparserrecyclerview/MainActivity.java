package com.example.jsonparserrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //1. Widgets
    RecyclerView recyclerView;

    //2. copy JSON file to the assets folder

    //3. ArrayLists for persons, names, email, id, mobile numbers
    ArrayList<String> personNames = new ArrayList<>();
    ArrayList<String> emailIds = new ArrayList<>();
    ArrayList<String> mobileNumbers = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        //4. RecyclerView configuration
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        //5. Get JSON
        try {
            //get JSON from JSON file
            JSONObject obj = new JSONObject(loadJSONfromAssets());

            //7. Fetch JSONArray named users
            JSONArray userArray = obj.getJSONArray("users");

            //8. Implementation of loop for getting users list data
            for (int i=0 ; i<userArray.length() ; i++){

                //9. Creating a JSONOBJECT for fetching single user data
                JSONObject userDetail = userArray.getJSONObject(i);

                //10. Fetching name and email an storing them in ArrayList
                personNames.add(userDetail.getString("name"));
                emailIds.add(userDetail.getString("email"));

                //11. Create an object for getting contact data from JSONObject
                JSONObject contact = userDetail.getJSONObject("contact");

                //Fetching Mobile number and storing it in ArrayList
                mobileNumbers.add(contact.getString("mobile"));


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        //13. Calling the CustomerAdapter to send the reference and data to adapter
        CustomAdapter customAdapter = new CustomAdapter(personNames, emailIds, mobileNumbers, MainActivity.this);
        recyclerView.setAdapter(customAdapter);


    }

    //6. Method for loading JSON from Assets
    private String loadJSONfromAssets() {
        String json = null;

        try {
            InputStream is = getAssets().open("users_list.json");
            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return json;
    }
}
