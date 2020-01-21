package com.example.projectdecember.WebApiJson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectdecember.R;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    ArrayList<Employee> employeeInfos;
    Context context;

    public EmployeeAdapter(ArrayList<Employee> employeeInfos, Context context) {
        this.employeeInfos = employeeInfos;
        this.context=context;
    }


    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_employee_info,null);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        final Employee employee = this.employeeInfos.get(position);

//        holder.name.setText("Name: "+employee.getName());
//         holder.contactNo.setText("Age: "+employee.getAge());
//        holder.status.setText("Salary: "+ employee.getSalary());
//        holder.age.setText("Age : "+employee.getAge());


        holder.name.setText("ID : "+employee.id);
        holder.contactNo.setText("Employee Name : "+employee.name);
        holder.status.setText("Salary : "+ employee.salary);
        holder.age.setText("Age : "+employee.age);


    }

    @Override
    public int getItemCount() {
        return employeeInfos.size();

    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder{

        TextView name, contactNo, status,age;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.userFullName);
            contactNo = itemView.findViewById(R.id.userContactNumber);
            status = itemView.findViewById(R.id.userStatus);
            age=itemView.findViewById(R.id.employee_age);


        }
    }
}
