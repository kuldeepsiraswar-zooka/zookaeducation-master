package com.kuldeep.zooka_education.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.kuldeep.zooka_education.R;
import com.kuldeep.zooka_education.TechPageTab.EBOOK;
import com.kuldeep.zooka_education.TechPageTab.FREECOURSE;
import com.kuldeep.zooka_education.TechPageTab.Home;
import com.kuldeep.zooka_education.TechPageTab.JOBSANDINTERN;
import com.kuldeep.zooka_education.TechPageTab.MODALPAPER;
import com.kuldeep.zooka_education.TechPageTab.PROJECTS;

import java.util.ArrayList;
import java.util.List;

public class TechPage extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentActivity myContext;
    public TechPage() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.techpage, container, false);
        viewPager = (ViewPager)v.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        return v;
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Home(), "Home");
        adapter.addFragment(new PROJECTS(), "Projects");
        adapter.addFragment(new FREECOURSE(), "Free-Course");
        adapter.addFragment(new JOBSANDINTERN(), "Jobs & Internship");
        adapter.addFragment(new EBOOK(), "Ebooks");
        adapter.addFragment(new MODALPAPER(), "Modal-Paper");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}