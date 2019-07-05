package com.example.userdata;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.userdata.dummy.DummyContent;
import com.example.userdata.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class PersonFragment extends Fragment {
    private static final String TAG = "PersonFragment";

    private ArrayList<Person> mPeopleList;
    private OnListFragmentInteractionListener mListener;
    private MyPersonRecyclerViewAdapter mAdapter;

    public PersonFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: starting...");
        View view = inflater.inflate(R.layout.fragment_person_list, container, false);
        mPeopleList = mListener.onListFragmentInteraction();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mAdapter = new MyPersonRecyclerViewAdapter(mPeopleList, (Context)mListener);
        recyclerView.setAdapter(mAdapter);

        return view;
    }


    @Override
    public void onResume() {
        Log.d(TAG, "onResume: starting...");
        super.onResume();
    }

    public void onItemAdded(){
        Log.d(TAG, "OnItemAdded: called...");
        mPeopleList = mListener.onListFragmentInteraction();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        public ArrayList<Person> onListFragmentInteraction();
    }
}
