package com.example.projectdecember.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectdecember.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NetworkConnectionFragment extends Fragment {


    public NetworkConnectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_network_connection, container, false);
    }

}