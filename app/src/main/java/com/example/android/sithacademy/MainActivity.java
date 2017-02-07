package com.example.android.sithacademy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment> fragments = getFragments();
        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;

        ViewGroup.LayoutParams params = pager.getLayoutParams();
        params.height = height / 4;
        pager.setLayoutParams(params);
        pager.setAdapter(pageAdapter);
    }

    private List<Fragment> getFragments() {

        List<Fragment> fragments = new ArrayList<Fragment>();

        fragments.add(MyFragment.newInstance(R.layout.page_general));
        fragments.add(MyFragment.newInstance(R.layout.page_menu));
        fragments.add(MyFragment.newInstance(R.layout.page_map));
        fragments.add(MyFragment.newInstance(R.layout.page_about_host));
        return fragments;
    }
}
