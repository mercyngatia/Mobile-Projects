package com.example.normalrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.normalrecyclerview.cardviewy.CardViewActivity;
import com.example.normalrecyclerview.multiselection.MultipleSelectionActivity;
import com.example.normalrecyclerview.normalrecycler.NormalRecyclerView;
import com.example.normalrecyclerview.singles.SingleSelectionRV;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NormalRecyclerView.class);
                startActivity(i);
            }
        });

        btn2 = findViewById(R.id.button_cardview);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CardViewActivity.class);
                startActivity(i);
            }
        });

        btn3 = findViewById(R.id.button_singlselection);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SingleSelectionRV.class);
                startActivity(i);
            }
        });

        btn4 = findViewById(R.id.button_multi_selection);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MultipleSelectionActivity.class);
                startActivity(i);
            }
        });

    }
}