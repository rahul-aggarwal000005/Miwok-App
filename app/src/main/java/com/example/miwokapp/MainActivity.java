package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


        TabLayout tabLayout = findViewById(R.id.tab_layout);

        ViewPager2 viewPager2 = findViewById(R.id.view_pager);


        ArrayList<String> Tabs = new ArrayList<>();
        Tabs.add("Numbers");
        Tabs.add("Family");
        Tabs.add("Colors");
        Tabs.add("Phrases");

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),getLifecycle());

        viewPager2.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText(Tabs.get(position))).attach();

    }
}