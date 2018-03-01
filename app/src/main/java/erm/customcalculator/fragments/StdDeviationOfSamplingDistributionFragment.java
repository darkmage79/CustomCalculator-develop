package erm.customcalculator.fragments;

/**
 * Created by Logan on 2/2/2016.
 */

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import erm.customcalculator.R;
import erm.customcalculator.classes.Utils;


import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.math.BigInteger;

import erm.customcalculator.R;
import erm.customcalculator.classes.Utils;
import erm.customcalculator.original.src.SRC_Calc_Type;

/**
 * Created by Logan on 2/1/2016.
 */
public class StdDeviationOfSamplingDistributionFragment extends CalcBase{

    public StdDeviationOfSamplingDistributionFragment(){}

    AppCompatEditText etN, etProbOfSuccess;
    double dblN;
    double dblProbOfSuccess;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_stddeviation, container,
                false);
        etN = (AppCompatEditText)v.findViewById(R.id.value_n);
        etProbOfSuccess = (AppCompatEditText)v.findViewById(R.id.value_success);

        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.std_deviation);
    }

    @Override
    public void clearPage() {
        etN.setText("");
        etProbOfSuccess.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {

        if(!Utils.isValidString(etN.getText().toString()) || !Utils.isValidString(etProbOfSuccess.getText().toString())) {
            return "Both values are needed for computation";
        } else {
            dblN = Double.valueOf(etN.getText().toString());
            dblProbOfSuccess = Double.valueOf(etProbOfSuccess.getText().toString());
            //place more checks here as needed
            return "";
        }
    }

    @Override
    public String calculate() {

        double result = (Math.sqrt(dblProbOfSuccess * (1-dblProbOfSuccess) / dblN));
        if(dblN * dblProbOfSuccess >=10 && result >= 10){
            return "This is a Normal Approximation, and the answer is " + String.valueOf(result);
        }

        if(dblN *dblProbOfSuccess <=10){
            return "This is not a Normal Approximation";
        }

        if(result <10){
            return "This is not a Sampling distrobution ";
        }

        return String.valueOf(result);
    }
}
