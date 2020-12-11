package com.example.jesseviauandroidtest.fragments;

import android.inputmethodservice.Keyboard;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jesseviauandroidtest.R;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IncomeTaxCalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IncomeTaxCalculatorFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IncomeTaxCalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IncomeTaxCalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IncomeTaxCalculatorFragment newInstance(String param1, String param2) {
        IncomeTaxCalculatorFragment fragment = new IncomeTaxCalculatorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    int salary, tax;
    double taxPercent;

    EditText salaryInput;
    TextView resultOutput;
    TextView taxPercentOutput;
    Button button;

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
        View view = inflater.inflate(R.layout.fragment_income_tax_calculator, container, false);

        String [] provinces = new String[]{"Ontario", "Quebec", "Nova Scotia", "New Brunswick", "Manitoba", "British Columbia", "P.E.I", "Saskatchewan", "Alberta", "N & L"};
        Spinner spinnerProvince = (Spinner) view.findViewById(R.id.spinnerProvince);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, provinces);
        spinnerProvince.setAdapter(adapter);
        spinnerProvince.setOnItemSelectedListener(this);

        salaryInput = (EditText) view.findViewById(R.id.salaryInput);
        resultOutput = (TextView) view.findViewById(R.id.resultTextView);
        taxPercentOutput = (TextView) view.findViewById(R.id.taxPercent);
        button = (Button) view.findViewById(R.id.calculateButton);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salary = Integer.parseInt(salaryInput.getText().toString());
                double fedTaxEstimate = salary*0.103;
                double provTaxEstimate = salary*0.053;
                double cppDeductions = salary*0.052;
                double eiDeductions = salary*0.015;
                double Total_Deductions = fedTaxEstimate+provTaxEstimate+cppDeductions+eiDeductions;


                double result = salary - (Total_Deductions);
                resultOutput.setText(String.valueOf(result));

            }
        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (position){
            //"Ontario", "Quebec", "Nova Scotia", "New Brunswick", "Manitoba", "British Columbia", "P.E.I", "Saskatchewan", "Alberta", "N & L"

            case 0:
                //ontario
                taxPercent = 0.13;
                taxPercentOutput.setText(String.valueOf(taxPercent*100) + "%");
                break;
            case 1:
                //Quebec
                taxPercent = 0.14975;
                taxPercentOutput.setText(String.valueOf(taxPercent*100) + "%");
                break;
            case 2:
            case 3:
            case 9:
                //Nova Scotia"
                //New Brunswick
                //N & L [9]
                taxPercent = 0.15;
                taxPercentOutput.setText(String.valueOf(taxPercent*100) + "%");
                break;
            case 4:
            case 5:
            case 6:
                //Manitoba
                //British Columbia
                //P.E.I
                taxPercent = 0.12;
                taxPercentOutput.setText(String.valueOf(taxPercent*100) + "%");
                break;
            case 7:
                //Saskatchewan
                taxPercent = 0.11;
                taxPercentOutput.setText(String.valueOf(taxPercent*100) + "%");
                break;
            case 8:
                //Alberta
                taxPercent = 0.05;
                taxPercentOutput.setText(String.valueOf(taxPercent*100) + "%");
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public double takeHomePayCalc(double salary, double taxPercent){

        double fedTax = 0;
        if( salary >= 48535){
            fedTax = (0.15*salary);
            if(salary > 48535 && salary <= 97069){
                fedTax = (0.20*salary);
            }
                if(salary > 97069 && salary <= 150473){
                    fedTax += (0.26*salary);
                }
                    if(salary > 150473 && salary <= 214368){
                        fedTax += (0.29*salary);
                    }
                        if(salary >= 214368){
                            fedTax += (0.33*salary);
                        }
        } else {
            return  salary * 0.13;
        }

        return salary - (fedTax + taxPercent);
    }
}