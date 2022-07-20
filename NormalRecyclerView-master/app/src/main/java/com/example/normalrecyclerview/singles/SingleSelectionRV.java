package com.example.normalrecyclerview.singles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.normalrecyclerview.R;

import java.util.ArrayList;

public class SingleSelectionRV extends AppCompatActivity {

    //widgets
    private RecyclerView recyclerView;
    private Button btn;

    //variables
    private ArrayList<Employee> employees = new ArrayList<>();
    private SingleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_selection_r_v);

        recyclerView = findViewById(R.id.singleRV);
        btn = findViewById(R.id.button_get_selected);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter = new SingleAdapter(this,employees);
        recyclerView.setAdapter(adapter);

        CreateList();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adapter.getSelected() != null){
                    ShowToast(adapter.getSelected().getName());
                }
                else
                    ShowToast("No Selection");
            }
        });
    }

    private void CreateList() {
        employees = new ArrayList<>();
        for (int i = 0 ; i <20 ; i++){
            Employee employee = new Employee();
            employee.setName("Employee " + (i+1));
            employees.add(employee);
        }
        adapter.setEmployees(employees);

    }
    private void ShowToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}