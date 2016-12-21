package com.epicodus.blake.bombdefuser.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.blake.bombdefuser.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CombinationFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.number0) Button mN0;
    @Bind(R.id.number1) Button mN1;
    @Bind(R.id.number2) Button mN2;
    @Bind(R.id.number3) Button mN3;
    @Bind(R.id.number4) Button mN4;
    @Bind(R.id.number5) Button mN5;
    @Bind(R.id.number6) Button mN6;
    @Bind(R.id.number7) Button mN7;
    @Bind(R.id.number8) Button mN8;
    @Bind(R.id.number9) Button mN9;
    @Bind(R.id.clearButton) Button mClearButton;
    @Bind(R.id.combinationTextView) TextView mCombinationTextView;

    private String combinationInput;


    public CombinationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_combination, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    public void onClick(View v) {
        if (v == mN0) {
            combinationInput.concat("0");
        }
        if (v == mN1) {
            combinationInput.concat("1");
        }
        if (v == mN2) {
            combinationInput.concat("2");
        }
        if (v == mN3) {
            combinationInput.concat("3");
        }
        if (v == mN4) {
            combinationInput.concat("4");
        }
        if (v == mN5) {
            combinationInput.concat("5");
        }
        if (v == mN6) {
            combinationInput.concat("6");
        }
        if (v == mN7) {
            combinationInput.concat("7");
        }
        if (v == mN8) {
            combinationInput.concat("8");
        }
        if (v == mN9) {
            combinationInput.concat("9");
        }
        if (v == mClearButton) {
            combinationInput = "";
        }

    }

    public String getCombinationInput() {
        return combinationInput;
    }

    public void setOnClickListeners() {
        mN0.setOnClickListener(this);
        mN1.setOnClickListener(this);
        mN2.setOnClickListener(this);
        mN3.setOnClickListener(this);
        mN4.setOnClickListener(this);
        mN5.setOnClickListener(this);
        mN6.setOnClickListener(this);
        mN7.setOnClickListener(this);
        mN8.setOnClickListener(this);
        mN9.setOnClickListener(this);
        mClearButton.setOnClickListener(this);
    }

}
