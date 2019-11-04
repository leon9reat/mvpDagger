package com.medialink.mvpmemorize.ui.extension;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.medialink.mvpmemorize.ui.film.FilmFeedFragment;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private int mPageSize;

    public SectionPagerAdapter(@NonNull FragmentManager fm, int pageSize) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mPageSize = pageSize;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FilmFeedFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mPageSize;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Film";
            case 1:
                return "Fragment 2 Title";
            default:
                return "";
        }
    }
}
