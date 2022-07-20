package com.example.jsonparser2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //widgets
    ListView listy;

    //JSON String
    //Format of JSON

    String json_string = "{\n" +
            " \"title\":\"JSONParseTutorial\",\n" +
            " \"array\":[\n" +
            "    {\n" +
            "    \"company\":\"Google\"\n" +
            "    },\n" +
            "    {\n" +
            "       \"company\":\"Facebook\"\n" +
            "    },\n" +
            "    {\n" +
            "       \"company\":\"LinkedIn\"\n" +
            "    },\n" +
            "    {\n" +
            "       \"company\": \"Microsoft\"\n" +
            "    },\n" +
            "    {\n" +
            "       \"company\": \"Apple\"\n" +
            "    }\n" +
            "    ],\n" +
            "    \"nested\":{\n" +
            "    \"flag\": true,\n" +
            "    \"random_number\":1\n" +
            "    }\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get JSON Objects
        try {
            listy = findViewById(R.id.list_view);

            //1. storing items in a list
            List<String> items = new ArrayList<>();

            //2. Create a JSON Object
            JSONObject root = new JSONObject(json_string);

            //3. Get data from array
            JSONArray array = root.getJSONArray("array");

            //4. Set the title
            this.setTitle(root.getString("title"));

            //5. Loop to get all the company details/objects
            for (int i = 0 ; i <array.length() ; i++){

                JSONObject object = array.getJSONObject(i);
                items.add(object.getString("company"));
            }

            //6. Create adapter for the ListView items
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items);

            if (listy != null){
                listy.setAdapter(adapter);
            }

            //7. Get nested objects from the root
            JSONObject nested = root.getJSONObject("nested");
            Log.d("TAG", "flag value" +nested.getBoolean("flag"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
