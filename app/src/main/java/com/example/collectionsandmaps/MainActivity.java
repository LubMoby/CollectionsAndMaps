package com.example.collectionsandmaps;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

public class MainActivity extends FragmentActivity{
    SectionsPagerAdapter pagerAdapter;
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return getResources().getText(R.string.collections_tab);
                case 1: return getResources().getText(R.string.maps_tab);
            }
            return null;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:return new CollectionsFragment();
                case 1:return new MapsFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
