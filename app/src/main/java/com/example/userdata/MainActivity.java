package com.example.userdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private static final String TAG = "MainActivity";

    private SectionPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;


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

        adapter.addFragment(new RegistrationFragment(), "Registration");
        adapter.addFragment(new PersonFragment(), "List");

        viewPager.setAdapter(adapter);
    }


}
