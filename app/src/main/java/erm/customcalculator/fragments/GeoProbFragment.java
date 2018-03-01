package erm.customcalculator.fragments;

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
 * Created by ellio on 2/1/2016.
 */
public class GeoProbFragment extends CalcBase{

    public GeoProbFragment(){}

    AppCompatEditText etNumOfTrials, etProbOfSuccess;
    double dblNumberOfTrials;
    double dblProbOfSuccess;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_geoprob, container,
                false);
        etNumOfTrials = (AppCompatEditText)v.findViewById(R.id.num_of_trials);
        etProbOfSuccess = (AppCompatEditText)v.findViewById(R.id.prob_of_success);

        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.geometric_probability);
    }

    @Override
    public void clearPage() {
        etNumOfTrials.setText("");
        etProbOfSuccess.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {

        if(!Utils.isValidString(etNumOfTrials.getText().toString()) || !Utils.isValidString(etProbOfSuccess.getText().toString())) {
            return "Both values are needed for computation";
        } else {
            dblNumberOfTrials = Double.valueOf(etNumOfTrials.getText().toString());
            dblProbOfSuccess = Double.valueOf(etProbOfSuccess.getText().toString());
            //place more checks here as needed
            return "";
        }
    }

    @Override
    public String calculate() {

        return String.valueOf(dblProbOfSuccess * Math.pow((1 - dblProbOfSuccess), (dblNumberOfTrials- 1)));

    }
}
