package com.example.collectionsandmaps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.collectionsandmaps.main.collections.CollectionsFragment;
import com.example.collectionsandmaps.main.maps.MapsFragment;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity{
    SectionsPagerAdapter pagerAdapter;
    @BindView(R.id.pager) ViewPager pager;
    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindString(R.string.collections_tab) String tabCollections;
    @BindString(R.string.maps_tab) String tabMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(pager);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return tabCollections;
                case 1: return tabMaps;
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
