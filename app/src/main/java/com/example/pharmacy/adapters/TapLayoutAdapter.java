package com.example.pharmacy.adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pharmacy.fragments.DescriptionFragment;
import com.example.pharmacy.fragments.ProductsFragment;

public class TapLayoutAdapter extends FragmentPagerAdapter {
    // tab titles
    private String[] tabTitles = new String[]{"Products", "Description"};

    private Context myContext;
    int totalTabs;
    // overriding getPageTitle()
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    public TapLayoutAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ProductsFragment productsFragment = new ProductsFragment();
                return productsFragment;
            case 1:
                DescriptionFragment descriptionFragment = new DescriptionFragment();
                return descriptionFragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return tabTitles.length;
    }
}
