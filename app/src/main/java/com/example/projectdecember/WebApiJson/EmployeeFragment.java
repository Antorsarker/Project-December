package com.example.projectdecember.WebApiJson;




import android.app.ProgressDialog;



import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projectdecember.R;
import com.google.gson.Gson;


import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeeFragment extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<Employee> employees;


    private ProgressDialog progressDialog;
    private EmployeeRoot employeeRoot;


    public EmployeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //initializeData();

        recyclerView = view.findViewById(R.id.userListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
//    private void initializeData() {
//
//        employeeInfos = new ArrayList<>();
//        employeeInfos.add(new Employee("A","1",true));
//        employeeInfos.add(new Employee("B","2",true));
//        employeeInfos.add(new Employee("C","3",false));
//        employeeInfos.add(new Employee("D","4",true));
//        employeeInfos.add(new Employee("F","5",true));
//        employeeInfos.add(new Employee("F","6",false));
//        employeeInfos.add(new Employee("G","7",false));
//        employeeInfos.add(new Employee("H","8",true));
//        employeeInfos.add(new Employee("I","9",true));
//        employeeInfos.add(new Employee("J","10",true));
//        employeeInfos.add(new Employee("K","11",false));
//        employeeInfos.add(new Employee("L","12",true));
//        employeeInfos.add(new Employee("M","13",true));
//
//
//
//    }


//
//    @Override
//    public void onResume() {
//        super.onResume();
//        new WebAPI().execute();
//    }
//
//    class WebAPI extends AsyncTask<Void, Void, JSONArray> {
//
//        @Override
//        protected void onPreExecute() {
//            progressDialog = new ProgressDialog(getActivity());
//            progressDialog.setMessage("Please wait...");
//            progressDialog.setCancelable(false);
//            progressDialog.show();
//        }
//
//        @Override
//        protected JSONArray doInBackground(Void... voids) {
//            try{
//                OkHttpClient client = new OkHttpClient();
//                Request request = new Request.Builder()
//                        .url(CommonConstant.EMPLOYEE_LIST)
//                        .build();
//
//                Response response = client.newCall(request).execute();
//                if(response.isSuccessful())
//                    return new JSONArray(response.body().string());
//            }catch (Exception ex){
//                Log.e(CommonConstant.TAG,ex.getMessage());
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(JSONArray jsonArray) {
//            progressDialog.dismiss();
//            try {
//                if(jsonArray != null){
//                    employees = new ArrayList<>();
//                    for(int index=0;index<jsonArray.length();index++){
//                        Employee employee = new Employee();
//                        JSONObject jsonObject = jsonArray.getJSONObject(index);
//                        employee.setId(Integer.parseInt(jsonObject.getString("id")));
//                        employee.setAge(jsonObject.getString("employee_age"));
//                        employee.setName(jsonObject.getString("employee_name"));
//                        employee.setProfilePicture(jsonObject.getString("profile_image"));
//                        employee.setSalary(jsonObject.getString("employee_salary"));
//                        employees.add(employee);
//                    }
//                    // set data into adapter
//                    recyclerView.setAdapter(new EmployeeAdapter(employees,getActivity()));
//                }else{
//                    Log.e(CommonConstant.TAG, "Server Response null");
//                }
//            }catch (Exception ex){
//                Log.e(CommonConstant.TAG, ex.getMessage());
//            }
//
//        }
//    }
//






    @Override
    public void onResume() {
        super.onResume();
        callServerForData();
    }


    // TODO: volley call to server for response
    private void callServerForData(){
        try{
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);


            RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
            JsonArrayRequest emplyeeListRequest = new JsonArrayRequest(
                    Request.Method.GET,
                    CommonConstant.EMPLOYEE_LIST,
                    null,
                    new com.android.volley.Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // gson for parse data
                            try {
                                employeeRoot = new EmployeeRoot();
                                for(int index=0;index<response.length();index++){
                                    Employee employee = new Gson()
                                            .fromJson(response.get(index).toString(), Employee.class);
                                    employeeRoot.employees.add(employee);
                                }
                            }catch (Exception ex){
                                Log.e(CommonConstant.TAG, ex.getMessage());
                            }

                            Log.d(CommonConstant.TAG, employeeRoot.employees.size()+"");
                            recyclerView.setAdapter(new EmployeeAdapter(employeeRoot.employees,Objects.requireNonNull(getActivity())));
                            progressDialog.dismiss();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(CommonConstant.TAG, Objects.requireNonNull(error.getMessage()));
                    progressDialog.dismiss();
                }
            });
            requestQueue.add(emplyeeListRequest);
            progressDialog.show();
        }catch (Exception ex){
            Log.e(CommonConstant.TAG, ex.getMessage());
        }
    }







}
