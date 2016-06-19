package com.foxplan.kiosk;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    PagerAdapter mSwipingViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Kezdő oldal felépítése
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar_layout);
        setSupportActionBar(toolbar);

        // Lapozható lista betöltése
        ViewPager viewPager = (ViewPager) findViewById(R.id.id_viewpager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NetworkListFragment(), "Nearby");
        adapter.addFragment(new NetworkListFragment(), "Active");
        viewPager.setAdapter(adapter);

        // Lapfülek inicializálása
        TabLayout tabLayout = (TabLayout) findViewById(R.id.id_tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }
}