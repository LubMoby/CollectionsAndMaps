package com.example.collectionsandmaps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.collectionsandmaps.collections.CollectionsFragment;
import com.example.collectionsandmaps.dagger.DaggerCollectionsAndMapsComponent;
import com.example.collectionsandmaps.dagger.CollectionsAndMapsComponent;
import com.example.collectionsandmaps.maps.MapsFragment;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity{
    SectionsPagerAdapter pagerAdapter;
    @BindView(R.id.pager) ViewPager pager;
    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindString(R.string.collections_tab) String tabCollections;
    @BindString(R.string.maps_tab) String tabMaps;

    @Inject
    MapsFragment MapsFragment;

    @Inject
    CollectionsFragment CollectionsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        CollectionsAndMapsComponent collectionsAndMapsComponent = DaggerCollectionsAndMapsComponent.create();
        collectionsAndMapsComponent.inject(this);
        collectionsAndMapsComponent.inject(MapsFragment);
        collectionsAndMapsComponent.inject(CollectionsFragment);


        pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

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
                case 0: return tabCollections;
                case 1: return tabMaps;
            }
            return null;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:return CollectionsFragment;
                case 1:return MapsFragment;
            }
            return null;
        }
        @Override
        public int getCount() {
            return 2;
        }
    }
}
