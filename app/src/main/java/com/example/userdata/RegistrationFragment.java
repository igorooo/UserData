package com.example.userdata;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment {
    private static final String TAG = "RegistrationFragment";

    private EditText mEditText_name, mEditText_surname, mEditText_login,
                     mEditText_date, mEditText_email;

    private ImageButton mButton_save, mButton_clear;
    private OnRegistrationFragmentInteractionListener mListener;

    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: starting...");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        mEditText_name = (EditText) view.findViewById(R.id.editText_name);
        mEditText_surname = (EditText) view.findViewById(R.id.editText_surname);
        mEditText_login = (EditText) view.findViewById(R.id.editText_login);
        mEditText_date = (EditText) view.findViewById(R.id.editText_date);
        mEditText_email = (EditText) view.findViewById(R.id.editText_email);
        mButton_clear = (ImageButton) view.findViewById(R.id.Button_clear);
        mButton_save = (ImageButton) view.findViewById(R.id.Button_save);

        return view;
    }



    public interface OnRegistrationFragmentInteractionListener{
        public void onRegistrationFragmentListener();
    }

}
