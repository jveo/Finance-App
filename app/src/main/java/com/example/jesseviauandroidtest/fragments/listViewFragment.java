package com.example.jesseviauandroidtest.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jesseviauandroidtest.MainActivity;
import com.example.jesseviauandroidtest.R;
import com.example.jesseviauandroidtest.pojo.listViewItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link listViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class listViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView answer;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public listViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment listViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static listViewFragment newInstance(String param1, String param2) {
        listViewFragment fragment = new listViewFragment();
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
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);

        MainActivity.fab.show();

        final ListView listView = view.findViewById(R.id.faqList);
        answer = view.findViewById(R.id.description);
        ArrayList<listViewItem> listViewItemArrayList = new ArrayList<>();
        listViewItemArrayList.add(new listViewItem( "A credit score is a numeric rating creditors use to assess borrower risk in making lending decisions. The most commonly used credit score is from FICO. This rating is defined by how much debt you have, whether you pay your bills on time, how many credit cards you have and any unpaid bills, among other factors.", "What’s a Credit Score?"));
        listViewItemArrayList.add(new listViewItem("A RRSP is a retirement plan offered by an employer that allows you to take a percentage of your paycheck (you decide how much) and put it aside for your retirement. This money usually gets invested on your behalf in a variety of stocks and bonds so that your money can create more money. You choose your investments, either directly or by picking a mix that reflects how much risk you’re comfortable with. The money that goes into your 401(k) is taken from your paycheck before taxes, reducing your taxable income.", "What Is a RRSP?"));
        listViewItemArrayList.add(new listViewItem("TFSA is an acronym for a section of the IRS Code, “Individual Retirement Arrangement” or “Individual Retirement Account” — a place to put money away for retirement that will be then invested for you.","What Is an TFSA?"));
        listViewItemArrayList.add(new listViewItem("APR is an acronym for “annual percentage rate.” It primarily matters if you plan on not paying off your credit card bill every month. APR is the interest rate you will be charged on any amount you did not pay in full from your last statement balance.","What Is APR? How Do Interest Rates Work?"));
        listViewItemArrayList.add(new listViewItem("The answer to this question varies depending on your circumstances. While there are some general, personal questions to ask yourself when assessing which debts are worth it, only you can really determine whether your debt is good or bad.", "What Is ‘Good Debt’?"));
        listViewItemArrayList.add(new listViewItem("That’s up to you. What’s your current credit score? And how responsible have you been with the credit cards you already have? Having an assortment of cards could strengthen your credit score, but having too many could be asking for trouble.", "How Many Credit Cards Should I Have?"));
           ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),
                  android.R.layout.simple_list_item_1, listViewItemArrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("look here somewhere", "" + position);
                answer.setText(
                        ((listViewItem)listView.getItemAtPosition(position)).getAnswer()
                        //dataTypeItemArrayList.get(position).getDescription();
                );
            }
        });


        return view;
    }

    public class CustomListViewAdapter extends ArrayAdapter<listViewItem> {

        //CustomListViewAdapter adapter = new CustomListViewAdapter(getContext(), dataTypeItemArrayList);
        public CustomListViewAdapter(@NonNull Context context, ArrayList<listViewItem> items) {
            super(context, 0, items);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if(convertView == null){
                convertView  =
                        LayoutInflater.from(getContext())
                                .inflate(R.layout.listview_item, parent, false);
                TextView name  = convertView.findViewById(R.id.name);
                name.setText(getItem(position).getQuestion());
                TextView description = convertView.findViewById(R.id.itemDescription);
                description.setText(getItem(position).getAnswer());
            }

            return convertView;
        }
    }
}