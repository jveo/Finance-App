package com.example.jesseviauandroidtest.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jesseviauandroidtest.MainActivity;
import com.example.jesseviauandroidtest.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmiCalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmiCalculatorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EmiCalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmiCalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmiCalculatorFragment newInstance(String param1, String param2) {
        EmiCalculatorFragment fragment = new EmiCalculatorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    int salary, tax;
    double taxPercent;


    TextView loanAmountResult;
    TextView emiResult;
    TextView totalInterestResult;
    TextView termResult;
    TextView totalPaymentResult;

    EditText loanAmountEditText;
    EditText InterestRateEditText;
    EditText TermEditText;
    Button emiCalculateButton;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_emi_calculator, container, false);

        //User Inputs
        loanAmountEditText = (EditText) view.findViewById(R.id.loanAmountEditText);
        InterestRateEditText = (EditText) view.findViewById(R.id.InterestRateEditText);
        TermEditText = (EditText) view.findViewById(R.id.LoanTermEditText);
        //Result Outputs
        loanAmountResult = (TextView) view.findViewById(R.id.LoanAmountResult);
        emiResult = (TextView) view.findViewById(R.id.emiResult);
        totalInterestResult = (TextView) view.findViewById(R.id.totalInterestResult);
        termResult = (TextView) view.findViewById(R.id.termResult);
        //BUTTON
        emiCalculateButton = (Button) view.findViewById(R.id.emiCalculateButton);
        emiCalculateButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                double loan = Integer.parseInt(loanAmountEditText.getText().toString());
                int term = Integer.parseInt(TermEditText.getText().toString());
                term = term*12;
                double interest = Integer.parseInt(InterestRateEditText.getText().toString());

                double totalInterestResult1 = loan*(interest/100);
                double emiResult1 = Math.round((loan + totalInterestResult1) / term);

                loanAmountResult.setText("$" + loanAmountEditText.getText());
                emiResult.setText("$" + String.valueOf((int)emiResult1));
                totalInterestResult.setText("$" + String.valueOf((int)totalInterestResult1));
                termResult.setText(String.valueOf(term) + " months");
            }
        });

        return view;
    }
}