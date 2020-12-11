package com.example.jesseviauandroidtest.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jesseviauandroidtest.CustomRecyclerViewAdapter;
import com.example.jesseviauandroidtest.MainActivity;
import com.example.jesseviauandroidtest.R;
import com.example.jesseviauandroidtest.pojo.Term;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link financeTerminologyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class financeTerminologyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public financeTerminologyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment financeTerminologyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static financeTerminologyFragment newInstance(String param1, String param2) {
        financeTerminologyFragment fragment = new financeTerminologyFragment();
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
        MainActivity.fab.hide();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finance_terminology, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycle);
        //List of items
        ArrayList<Term> Terms = new ArrayList<>();
        Terms.add(new Term("Net income", "This refers to a company’s total earnings or profit."));
        Terms.add(new Term("Depreciation", "loses some of that value in increments over time"));
        Terms.add(new Term("Accounts Payable", "This represents your small business’s obligations to pay debts owed to lenders, suppliers, and creditors."));
        Terms.add(new Term("Accounts Receivable", "This means the money owed to your small business by others for goods or services rendered."));
        Terms.add(new Term("Asset(s)", " anything that has value—whether tangible or intangible—and is owned by the business is considered an asset."));
        Terms.add(new Term("BalanceSheet", "essential information that gives a “snapshot” of the company’s net worth at any given time."));
        Terms.add(new Term("Captial", "Refers to the overall wealth of a business as demonstrated by its cash accounts, assets, and investments."));
        Terms.add(new Term("Working Capital", "It consists of the financial resources necessary for maintaining the day-to-day operation of the business."));
        //Layout Manager
        /**
         * comment out when choosing another layout variation
         */
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        /**
         * Linear layout
         * uncomment for use
         */
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
//                LinearLayoutManager.HORIZONTAL,
//                false));
        /**
         * Grid layout
         */
//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        /**
         * Staggered layout
         */
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,
//                  LinearLayoutManager.VERTICAL));
        // new LinearLayoutManager()

        //Set an adapter
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(Terms));

        return view;
    }
}