package com.example.jsonparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //Widgets
    TextView name, salary;

    //JSON STRING
    String JSON_STRING = "{\"employee\":{\"name\":\"Mercy Ngatia\",\"salary\":50000}}";

    String namee, salaryy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference for TextView
        name = findViewById(R.id.name);
        salary = findViewById(R.id.salary);

        //Getting JSON Objects
        try {
            //Get JSON Object from json file
            JSONObject obj = new JSONObject(JSON_STRING);

            //Get JSON Object named employee
            JSONObject employee = obj.getJSONObject("employee");

            //Getting Employee name and salary inside json object (employee)
            namee = employee.getString("name");
            salaryy = employee.getString("salary");


            //setting TextView
            name.setText("Name:"+ namee);
            salary.setText("Salary" + salaryy);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
