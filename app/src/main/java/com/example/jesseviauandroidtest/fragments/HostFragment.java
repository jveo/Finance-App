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
                case 0: return ViewPagerFragment.newInstance("Step 1: Gather Your Tax Documents", "Here are a few things you need:\n" +
                        "\n" +
                        "W-2s\n" +
                        "1099s\n" +
                        "Mortgage interest statements\n" +
                        "Investment income statements");
                case 1: return ViewPagerFragment.newInstance("Step 2: Choose Between the Standard Deduction or Itemizing", "you have two choices: Take the standard deduction or itemize your deductions.\n If you do plan on itemizing deductions, you’ll need proof to back up your claims. So, don’t forget any receipts for deductions and tax credits like:\n" +
                        "\n" +
                        "Childcare\n" +
                        "Education costs\n" +
                        "Charitable giving\n" +
                        "Medical expenses");
                case 2: return ViewPagerFragment.newInstance("Step 3: Pick a Filing Status", "Single. If you’re not married, divorced or legally separated, or widowed before the tax year, you’ll file as a single taxpayer. Simple enough, right?\n" +
                        "Married Filing Jointly. You’re married and both of you agree to file a joint return. In most cases, married couples usually save more by filing jointly.\n" +
                        "Married Filing Separately. If you’re married and for some reason don’t agree to file jointly—maybe you want to be responsible for your taxes only or filing separately results in a lower tax bill—you can use this filing status.\n" +
                        "Head of Household. This one’s a little tricky. To qualify you must have paid for more than half of the household expenses for the year, be unmarried, and must have a “qualifying child or dependent.” So, if you’re a single parent or taking care of an ailing family member, you might qualify to file as head of household.\n" +
                        "Qualifying widow(er). If your spouse dies and you don’t remarry in the same tax year, you can file jointly with your deceased spouse. For the two years following the year of death, you can use the qualifying widow(er) filing status if you choose to.1");
                case 3: return ViewPagerFragment.newInstance("Step 4: File Your Taxes", "Once you have all your documents organized, you’re ready to file your taxes!\n" +
                        "\n" +
                        "According to the IRS, most Americans chose to hire a professional (58%) to help them file their tax returns electronically. The rest decided to file on their own using tax software or going old school and filing by paper and mailing it in.");
                case 4: return ViewPagerFragment.newInstance("Step 5: Get Organized for Next Year", "If you end up with a big tax refund or a large tax bill, you probably want to go ahead and adjust your paycheque so that you’re not taking too much or too little out of your paycheck for taxes.");
                default: return ViewPagerFragment.newInstance("error", "401");
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}