package com.example.userdata;


import android.content.Context;
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
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnRegistrationFragmentInteractionListener) {
            mListener = (OnRegistrationFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRegistrationFragmentInteractionListener");
        }
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

        mButton_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClearButtonClick();
            }
        });

        mButton_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveButtonClick();
            }
        });

        return view;
    }


    private void onSaveButtonClick(){
        Log.d(TAG, "onSaveButtonClick: clicked...");
        Person person = new Person(mEditText_name.getText().toString(),
                                    mEditText_surname.getText().toString(),
                                    mEditText_login.getText().toString(),
                                    mEditText_date.getText().toString(),
                                    mEditText_email.getText().toString());

        mListener.onRegistrationFragmentListener(person);
    }

    private void onClearButtonClick(){
        Log.d(TAG, "onClearButtonClick: clicked...");
        mEditText_name.getText().clear();
        mEditText_surname.getText().clear();
        mEditText_login.getText().clear();
        mEditText_date.getText().clear();
        mEditText_email.getText().clear();
    }



    public interface OnRegistrationFragmentInteractionListener{
        public void onRegistrationFragmentListener(Person person);
    }

}
