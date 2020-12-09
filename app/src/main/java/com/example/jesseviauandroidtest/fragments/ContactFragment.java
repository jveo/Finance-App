package com.example.jesseviauandroidtest.fragments;

import android.Manifest;

import android.app.AlertDialog;
import android.content.DialogInterface;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.jesseviauandroidtest.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static final int PERMISSION_SEND_SMS = 0;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
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

        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        // all necessary variables to hold all the buttons
        Button emailButton = view.findViewById(R.id.emailButton);
        Button phoneButton = view.findViewById(R.id.phoneButton);
        Button textButton = view.findViewById(R.id.textButton);
        Button locationButton = view.findViewById(R.id.locationButton);

        //PHONE button event listener
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri phoneNumber = Uri.parse("tel:226-111-1111");
                Intent intent = new Intent(Intent.ACTION_DIAL, phoneNumber);
                if(intent.resolveActivity(getActivity().getPackageManager())!= null){
                    startActivity(intent);
                } else {
                    //toast warning
                    Toast.makeText(getContext(), "No app installed", Toast.LENGTH_LONG).show();
                }
            }
        });

        //EMAIL button event listener
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] emailAddresses = {"jesse.viau92@stclairconnect.ca",};
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, emailAddresses);
                intent.putExtra(Intent.EXTRA_CC, "finaid@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Meeting Request");

                if(intent.resolveActivity(getActivity().getPackageManager())!= null){
                    startActivity(intent);
                } else {
                    //toast warning
                    Toast.makeText(getContext(), "No app installed", Toast.LENGTH_LONG).show();
                }
            }
        });


        //TEXT button even listener
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * checks to see if we don't have permission
                 *
                 * then checks if we asked for the permission before
                 *
                 * Requests permission
                 */
                if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
                    Log.d("FinancialEd-error", "NO PERMISSION");
                    if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.SEND_SMS)){

                        Log.d("FinancialEd-error", "Should show rationale");

                        final AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                        alertDialog.setTitle("SMS Permission");
                        alertDialog.setMessage("We need access to SMS to send a messages");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                alertDialog.dismiss();
                                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.SEND_SMS}, PERMISSION_SEND_SMS);
                            }
                        });

                    } else {
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.SEND_SMS}, PERMISSION_SEND_SMS);
                    }
                } else {
                    Uri phoneNumber = Uri.parse("tel:226-111-1111");
                    Intent intent  = new Intent(Intent.ACTION_SENDTO, phoneNumber);
                    intent.setData(Uri.parse("smsto:"));
                    intent.putExtra("sms_body", "Hi FinancialEd!\n");

                    if(intent.resolveActivity(getActivity().getPackageManager())!= null){
                        startActivity(intent);
                    } else {
                        //toast warning
                        Toast.makeText(getContext(), "No app installed", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        //LOCATION button event listener
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //parse the URI for the location
                Uri locationUri = Uri.parse("geo:0,0?42.24867,-83.0209258,3a,75y,133.4h,90t");
                Intent intent = new Intent(Intent.ACTION_VIEW, locationUri);

                //fail safe IF the packageManager doesn't exist
                if(intent.resolveActivity(getActivity().getPackageManager())!= null){
                    startActivity(intent);
                } else {
                    //toast warning
                    Toast.makeText(getContext(), "No app installed", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}