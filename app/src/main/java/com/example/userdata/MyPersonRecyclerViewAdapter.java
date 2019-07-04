package com.example.userdata;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;


public class MyPersonRecyclerViewAdapter extends RecyclerView.Adapter<MyPersonRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "MyPhotoRecyclerView";

    private ArrayList<Person> mPeopleList;
    private Context mContext;

    //@TODO Before adding internal storage use, there will be 1 photo displayed 10 times

    private int mCount = 10;
    private Bitmap mPhoto;

    public MyPersonRecyclerViewAdapter(ArrayList<Person> peopleList, Context mContext) {
        this.mPeopleList = peopleList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called ...");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_person, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called ...");

        holder.name.setText(mPeopleList.get(position).getmName());
        holder.surname.setText(mPeopleList.get(position).getmSurname());
        holder.login.setText(mPeopleList.get(position).getmLogin());
        holder.date.setText(mPeopleList.get(position).getmDate());
        holder.email.setText(mPeopleList.get(position).getmEmail());
    }

    @Override
    public int getItemCount() {
        return mPeopleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,surname,login,date,email;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView_name);
            surname = (TextView) itemView.findViewById(R.id.textView_surname);
            login = (TextView) itemView.findViewById(R.id.textView_login);
            date = (TextView) itemView.findViewById(R.id.textView_date);
            email = (TextView) itemView.findViewById(R.id.textView_email);
        }
    }
}