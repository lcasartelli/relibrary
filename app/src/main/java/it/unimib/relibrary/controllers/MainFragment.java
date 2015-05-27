package it.unimib.relibrary.controllers;/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import it.unimib.relibrary.R;
import it.unimib.relibrary.common.view.SlidingTabLayout;

/**
 * A basic sample which shows how to use {@link it.unimib.relibrary.common.view.SlidingTabLayout}
 * to display a custom {@link ViewPager} title strip which gives continuous feedback to the user
 * when scrolling.
 */
public class MainFragment extends Fragment {

    /**
     * A custom {@link ViewPager} title strip which looks much like Tabs present in Android v4.0 and
     * above, but is designed to give continuous feedback to the user when scrolling.
     */
    private SlidingTabLayout mSlidingTabLayout;

    /**
     * A {@link ViewPager} which will be used in conjunction with the {@link SlidingTabLayout} above.
     */
    private ViewPager mViewPager;

    /**
     * Inflates the {@link View} which will be displayed by this {@link Fragment}, from the app's
     * resources.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    // BEGIN_INCLUDE (fragment_onviewcreated)

    /**
     * This is called after the {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)} has finished.
     * Here we can pick out the {@link View}s we need to configure from the content view.
     * <p/>
     * We set the {@link ViewPager}'s adapter to be an instance of {@link SamplePagerAdapter}. The
     * {@link SlidingTabLayout} is then given the {@link ViewPager} so that it can populate itself.
     *
     * @param view View created in {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // BEGIN_INCLUDE (setup_viewpager)
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager2);
        FragmentManager fm = getFragmentManager();
        mViewPager.setAdapter(new SamplePagerAdapter(fm));
        // END_INCLUDE (setup_viewpager)

        // BEGIN_INCLUDE (setup_slidingtablayout)
        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setNumberOfTabsForView(3);
        mSlidingTabLayout.setViewPager(mViewPager);

        // END_INCLUDE (setup_slidingtablayout)
    }
    // END_INCLUDE (fragment_onviewcreated)

    /**
     * The {@link android.support.v4.view.PagerAdapter} used to display pages in this sample.
     * The individual pages are simple and just display two lines of text. The important section of
     * this class is the {@link #getPageTitle(int)} method which controls what is displayed in the
     * {@link SlidingTabLayout}.
     */
    class SamplePagerAdapter extends FragmentPagerAdapter {

        private ArrayList<String> TITLES;
        private ArrayList<String> FRAGMENTS_CLASSES;

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);

            TITLES = new ArrayList<String>();
            FRAGMENTS_CLASSES = new ArrayList<String>();

            FRAGMENTS_CLASSES.add(HomeFragment.class.getName());
            TITLES.add(HomeFragment.getTitle());

            FRAGMENTS_CLASSES.add(MyStuffsFragment.class.getName());
            TITLES.add(MyStuffsFragment.getTitle());

            FRAGMENTS_CLASSES.add(NotificationsFragment.class.getName());
            TITLES.add(NotificationsFragment.getTitle());
        }

        /**
         * @return the number of pages to display
         */
        @Override
        public int getCount() {
            return FRAGMENTS_CLASSES.size();
        }

        /**
         * @return true if the value returned from {@link #instantiateItem(ViewGroup, int)} is the
         * same object as the {@link View} added to the {@link ViewPager}.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            return TITLES.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return Fragment.instantiate(getActivity().getBaseContext(), FRAGMENTS_CLASSES.get(position));
        }

    }
}
