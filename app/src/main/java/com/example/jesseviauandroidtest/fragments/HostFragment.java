package com.example.jesseviauandroidtest.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jesseviauandroidtest.R;
import com.example.jesseviauandroidtest.helperfragments.ViewPagerFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HostFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HostFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HostFragment newInstance(String param1, String param2) {
        HostFragment fragment = new HostFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_host, container, false);
        CustomerViewPagerAdapter adapter = new CustomerViewPagerAdapter(getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.hostContent);
        viewPager.setAdapter(adapter);
        return view;
    }

    public class CustomerViewPagerAdapter extends FragmentPagerAdapter{

        public CustomerViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            //switch position
            switch (position){
                case 0: return ViewPagerFragment.newInstance("phone,email and text intents");
                case 1: return ViewPagerFragment.newInstance("created view pager with dynamic text");
                case 2: return ViewPagerFragment.newInstance("created navigation side bar");
                case 3: return ViewPagerFragment.newInstance("Created a location link to long/lat");
                default: return ViewPagerFragment.newInstance("project not found");
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}