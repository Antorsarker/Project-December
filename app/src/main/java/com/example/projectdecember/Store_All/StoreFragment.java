package com.example.projectdecember.Store_All;

import android.app.ProgressDialog;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.GridLayoutManager;
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
import com.example.projectdecember.WebApiJson.CommonConstant;
import com.google.gson.Gson;


import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoreFragment extends Fragment {



    private RecyclerView recyclerView;
    private ArrayList<Movie> movieList;
   // private StoreAdapter mAdapter;

    private ProgressDialog progressDialog;
    private StoreRoot storeRoot;


    public StoreFragment() {
        // Required empty public constructor
    }

//    public static StoreFragment newInstance(String param1, String param2) {
//        StoreFragment fragment = new StoreFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



//        recyclerView = view.findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView = view.findViewById(R.id.recycler_view);
      recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

//    movieList = new ArrayList<>();
//        mAdapter = new StoreAdapter(getActivity(), movieList);
//
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
//        recyclerView.setLayoutManager(mLayoutManager);
//        // recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);
//        recyclerView.setNestedScrollingEnabled(false);


    }

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
                    StoreConstant.URL,
                    null,
                    new com.android.volley.Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // gson for parse data
                            try {
//                                employeeRoot = new EmployeeRoot();
//                                for(int index=0;index<response.length();index++){
//                                    Employee employee = new Gson()
//                                            .fromJson(response.get(index).toString(), Employee.class);
//                                    employeeRoot.employees.add(employee);

                                storeRoot = new StoreRoot();
                                for(int index=0;index<response.length();index++){
                                    Movie movie = new Gson()
                                            .fromJson(response.get(index).toString(), Movie.class);
                                    storeRoot.movieList.add(movie);

                                }
                            }catch (Exception ex){
                                Log.e(StoreConstant.TAG, ex.getMessage());
                            }

                            Log.d(CommonConstant.TAG, storeRoot.movieList.size()+"");
                            recyclerView.setAdapter(new StoreAdapter(Objects.requireNonNull(getActivity()), storeRoot.movieList));
                            progressDialog.dismiss();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(StoreConstant.TAG, Objects.requireNonNull(error.getMessage()));
                    progressDialog.dismiss();
                }
            });
            requestQueue.add(emplyeeListRequest);
            progressDialog.show();
        }catch (Exception ex){
            Log.e(CommonConstant.TAG, ex.getMessage());
        }
    }

    //    private void fetchStoreItems() {
//        JsonArrayRequest request = new JsonArrayRequest(URL,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        if (response == null) {
//                            Toast.makeText(getActivity(), "Couldn't fetch the store items! Pleas try again.", Toast.LENGTH_LONG).show();
//                            return;
//                        }
//
//                        List<Movie> items = new Gson().fromJson(response.toString(), new TypeToken<List<Movie>>() {
//                        }.getType());
//
//                        movieList.clear();
//                        movieList.addAll(items);
//
//                        // refreshing recycler view
//                        mAdapter.notifyDataSetChanged();
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // error in getting json
//                Log.e(TAG, "Error: " + error.getMessage());
//                Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        MyApplication.getInstance().addToRequestQueue(request);
//
//
//    }




//    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
//
//        private int spanCount;
//        private int spacing;
//        private boolean includeEdge;
//
//        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
//            this.spanCount = spanCount;
//            this.spacing = spacing;
//            this.includeEdge = includeEdge;
//        }
//
//        @Override
//        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//            int position = parent.getChildAdapterPosition(view); // item position
//            int column = position % spanCount; // item column
//
//            if (includeEdge) {
//                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
//                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)
//
//                if (position < spanCount) { // top edge
//                    outRect.top = spacing;
//                }
//                outRect.bottom = spacing; // item bottom
//            } else {
//                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
//                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
//                if (position >= spanCount) {
//                    outRect.top = spacing; // item top
//                }
//            }
//        }
//    }
//
//    /**
//     * Converting dp to pixel
//     */
//    private int dpToPx(int dp) {
//        Resources r = getResources();
//        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
//    }



    }



