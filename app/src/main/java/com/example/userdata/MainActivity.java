package com.example.userdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

// @TODO implement interfaces, do communication with fragments, check SP methods, test, buttons

public class MainActivity extends FragmentActivity implements
        RegistrationFragment.OnRegistrationFragmentInteractionListener,
        PersonFragment.OnListFragmentInteractionListener {
    private static final String TAG = "MainActivity";

    // --Shared Prefs constants:
    private static final String SHARED_PREFS = "SP";
    private static final String SP_USERS = "SP_USERS";

    private SectionPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private PersonFragment mListFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: starting...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        setupViewPager(mViewPager, mSectionPageAdapter);
    }

    private void setupViewPager(ViewPager viewPager, SectionPageAdapter adapter){

        //need to store ref to fragment with list for future notifications
        mListFragment = new PersonFragment();

        adapter.addFragment(new RegistrationFragment(), "Registration");
        adapter.addFragment(mListFragment, "List");

        viewPager.setAdapter(adapter);
    }





    public ArrayList<Person> loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(SP_USERS,"");
        Type type = new TypeToken<ArrayList<Person>>(){}.getType();
        ArrayList<Person> peopleList = gson.fromJson(json, type);

        if(peopleList == null){
            peopleList = new ArrayList<Person>();
        }

        return peopleList;
    }

    public void addPosition(Person person){

        ArrayList<Person> photosList = loadData();
        photosList.add(person);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(photosList);
        editor.putString(SP_USERS,json);
        editor.apply();

        refreshListFragment();
    }

    //@TODO Dynamic ListFragment (PersonFragment) refreshing still not working

    private void refreshListFragment(){

        Log.d(TAG, "refreshListFragment: called...");

        if(mListFragment == null){
            Log.d(TAG, "refreshListFragment called on null object reference!");
            return;
        }

        mListFragment.onItemAdded();
        mListFragment.onResume();
        mSectionPageAdapter.notifyDataSetChanged();
    }


    @Override
    public ArrayList<Person> onListFragmentInteraction() {
        return loadData();
    }

    @Override
    public void onRegistrationFragmentListener(Person person) {
        addPosition(person);
    }
}
