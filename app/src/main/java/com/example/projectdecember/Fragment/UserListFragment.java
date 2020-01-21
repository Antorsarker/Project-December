package com.example.projectdecember.Fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectdecember.R;
import com.example.projectdecember.adapter.UserInfoAdapter;
import com.example.projectdecember.pojo.UserInfo;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {

     RecyclerView recyclerView;
    private ArrayList<UserInfo> userInfos;
    UserInfoAdapter userInfoAdapter;




    public UserListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeData();


        userInfoAdapter=new UserInfoAdapter(userInfos,getActivity());
        recyclerView = view.findViewById(R.id.userListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(userInfoAdapter);

    }

    private void initializeData() {

        userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("A","1",true));
        userInfos.add(new UserInfo("B","2",true));
        userInfos.add(new UserInfo("C","3",false));
        userInfos.add(new UserInfo("D","4",true));
        userInfos.add(new UserInfo("F","5",true));
        userInfos.add(new UserInfo("F","6",false));
        userInfos.add(new UserInfo("G","7",false));
        userInfos.add(new UserInfo("H","8",true));
        userInfos.add(new UserInfo("I","9",true));
        userInfos.add(new UserInfo("J","10",true));
        userInfos.add(new UserInfo("K","11",false));
        userInfos.add(new UserInfo("L","12",true));
        userInfos.add(new UserInfo("M","13",true));



    }
}
