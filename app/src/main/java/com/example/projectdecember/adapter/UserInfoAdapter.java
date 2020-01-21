package com.example.projectdecember.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectdecember.R;
import com.example.projectdecember.pojo.UserInfo;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.UserInfoViewHolder> {

    ArrayList<UserInfo> userInfos;
    Context context;

    public UserInfoAdapter(ArrayList<UserInfo> userInfos, Context context) {
        this.userInfos = userInfos;
        this.context = context;
    }

    @NonNull
    @Override
    public UserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.adapter_user_info,null);

        return new UserInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserInfoViewHolder holder, int position) {

        UserInfo userInfo = this.userInfos.get(position);

        holder.name.setText("Name: "+userInfo.getFullName());
        holder.contactNo.setText("Contact Number: "+userInfo.getContactNumber());
        holder.status.setText("Is Active: "+ userInfo.isStatus());
    }

    @Override
    public int getItemCount() {
        return userInfos.size();
    }





    class UserInfoViewHolder extends RecyclerView.ViewHolder{

        TextView name, contactNo, status;

        public UserInfoViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.userFullName);
            contactNo = itemView.findViewById(R.id.userContactNumber);
            status = itemView.findViewById(R.id.userStatus);


        }
    }
}
