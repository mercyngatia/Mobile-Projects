package com.example.normalrecyclerview.multiselection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.normalrecyclerview.R;
import com.example.normalrecyclerview.singles.Employee;

import java.util.ArrayList;

public class MultipleAdapter extends RecyclerView.Adapter<MultipleAdapter.MultiViewHolder> {
    //Use same employee model class and item_employee.xml


    //1 - MultiAdapter class with implementation of it's methods
    private Context context;
    private ArrayList<Employee> employees;

    public MultipleAdapter(Context context, ArrayList<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }

    public void setEmployees(ArrayList<Employee> employees){
        this.employees = new ArrayList<>();
        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MultiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employee,
                parent, false);
        return new MultiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MultiViewHolder holder, int position) {
        holder.bind(employees.get(position));

    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    //2. ViewHolder class
    class MultiViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public MultiViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.emp_name);
            imageView = itemView.findViewById(R.id.imageviewy);
        }

        //Get the selected items
        void bind(final Employee employee){
            imageView.setVisibility(employee.isChecked() ? View.VISIBLE : View.GONE);
            textView.setText(employee.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    employee.setChecked(!employee.isChecked());
                    imageView.setVisibility(employee.isChecked() ? View.VISIBLE : View.GONE);
                }
            });
        }
    }

    //Get all items selected
    public ArrayList<Employee> getAll(){
        return employees;
    }
    //When button clicked, get selected
    public ArrayList<Employee> getSelected() {
        ArrayList<Employee> selected = new ArrayList<>();
        for(int i = 0; i<employees.size() ; i ++){
            if (employees.get(i).isChecked()) {
                selected.add(employees.get(i));
            }
        }
        return selected;
    }


}
