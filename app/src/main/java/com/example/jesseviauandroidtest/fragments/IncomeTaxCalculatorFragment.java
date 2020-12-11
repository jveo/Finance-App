package com.example.jesseviauandroidtest.fragments;

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

import com.example.jesseviauandroidtest.R;

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

    int salary;

    double federalTax;
    double provincialTax;



    EditText salaryInput;
    TextView resultOutput;
    TextView estimatedFedTaxOutput;
    TextView estimatedProvTaxOutput;
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
        estimatedFedTaxOutput = (TextView) view.findViewById(R.id.estimatedFedTax);
        estimatedProvTaxOutput = (TextView) view.findViewById(R.id.estimatedProvTax);
        resultOutput = (TextView) view.findViewById(R.id.resultTextView);
        button = (Button) view.findViewById(R.id.calculateButton);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //FEDERAL TAX
                if(salary <= 48535){
                    federalTax = 0.15;
                }
                if(salary > 48535 && salary <= 97069){
                    federalTax = 0.2050;
                }
                if(salary > 97069 && salary <= 150473){
                    federalTax = 0.26;
                }
                if(salary > 150474 && salary <= 214368){
                    federalTax = 0.29;
                }
                if(salary > 214368){
                    federalTax = 0.33;
                }

                salary = Integer.parseInt(salaryInput.getText().toString());
                double result = Math.round(salary - (salary*(federalTax+provincialTax)));
                estimatedFedTaxOutput.setText(String.valueOf(federalTax) + "%");
                estimatedProvTaxOutput.setText(String.valueOf(provincialTax) + "%");
                resultOutput.setText("$" + String.valueOf(result));

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
                if(salary <= 44740){
                    provincialTax = 0.0505;
                }
                if(salary > 44740 && salary <= 89482){
                    provincialTax = 0.0915;
                }
                if(salary > 89482 && salary <= 150000){
                    provincialTax = 0.1116;
                }
                if(salary > 150000 && salary <= 220000){
                    provincialTax = 0.1216;
                }
                if(salary > 220000){
                    provincialTax = 0.1316;
                }
                break;
            case 1:
                //Quebec
                if(salary <= 44545){
                    provincialTax = 0.15;
                }
                if(salary > 44545 && salary <= 89080){
                    provincialTax = 0.20;
                }
                if(salary > 89080 && salary <= 108390){
                    provincialTax = 0.24;
                }
                if(salary > 108390){
                    provincialTax = 0.2575;
                }
                break;
            case 2:
                //Nova Scotia"
                if(salary <= 29590){
                    provincialTax = 0.0879;
                }
                if(salary > 29590 && salary <= 59180){
                    provincialTax = 0.1495;
                }
                if(salary > 59180 && salary <= 93000){
                    provincialTax = 0.1667;
                }
                if(salary > 93000 && salary <= 150000){
                    provincialTax = 0.1750;
                }
                if(salary > 150000){
                    provincialTax = 0.21;
                }
                break;
            case 3:
                //New Brunswick
                if(salary <= 43401){
                    provincialTax = 0.0968;
                }
                if(salary > 43401 && salary <= 86803){
                    provincialTax = 0.1482;
                }
                if(salary > 86803 && salary <= 141122){
                    provincialTax = 0.1652;
                }
                if(salary > 141122 && salary <= 160776){
                    provincialTax = 0.1784;
                }
                if(salary > 160776){
                    provincialTax = 0.2030;
                }
                break;
            case 4:
                //Manitoba
                if(salary <= 33389){
                    provincialTax = 0.1080;
                }
                if(salary > 33389 && salary <= 72165){
                    provincialTax = 0.1275;
                }
                if(salary > 72165){
                    provincialTax = 0.1740;
                }

                break;
            case 5:
                //British Columbia
                if(salary <= 41725){
                    provincialTax = 0.0506;
                }
                if(salary > 41725 && salary <= 83451){
                    provincialTax = 0.770;
                }
                if(salary > 83451 && salary <= 95812){
                    provincialTax = 0.1050;
                }
                if(salary > 95812 && salary <= 116344){
                    provincialTax = 0.1229;
                }
                if(salary > 116344 && salary <= 157748){
                    provincialTax = 0.1470;
                }
                if(salary > 157748){
                    provincialTax = 0.1680;
                }
                break;
            case 6:
                //P.E.I
                if(salary <= 31984){
                    provincialTax = 0.0980;
                }
                if(salary > 31984 && salary <= 63969){
                    provincialTax = 0.1380;
                }
                if(salary > 63969){
                    provincialTax = 0.1670;
                }
                break;
            case 7:
                //Saskatchewan
                if(salary <= 45225){
                    provincialTax = 0.1050;
                }
                if(salary > 45225 && salary <= 129214){
                    provincialTax = 0.1250;
                }
                if(salary > 129214){
                    provincialTax = 0.1450;
                }
                break;
            case 8:
                //Alberta
                if(salary <= 131220){
                    provincialTax = 0.10;
                }
                if(salary > 131220 && salary <= 157464){
                    provincialTax = 0.12;
                }
                if(salary > 157464 && salary <= 209952){
                    provincialTax = 0.13;
                }
                if(salary > 209952 && salary <= 314928){
                    provincialTax = 0.14;
                }
                if(salary > 314928){
                    provincialTax = 0.15;
                }
                break;
            case 9:
                //N & L
                if(salary <= 37929){
                    provincialTax = 0.0870;
                }
                if(salary > 37929 && salary <= 75858){
                    provincialTax = 0.1450;
                }
                if(salary > 75858 && salary <= 135432){
                    provincialTax = 0.1580;
                }
                if(salary > 135432 && salary <= 189604){
                    provincialTax = 0.1730;
                }
                if(salary > 189604){
                    provincialTax = 0.1830;
                }
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}