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
 * Created by Logan on 2/1/2016.
 */
public class CombinationFragment extends CalcBase{

    public CombinationFragment(){}

    AppCompatEditText etN,etR;
    int n,r;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_combination, container,
                false);
        etN = (AppCompatEditText)v.findViewById(R.id.value_n);
        etR = (AppCompatEditText)v.findViewById(R.id.value_r);

        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.combination);
    }

    @Override
    public void clearPage() {
        etR.setText("");
        etN.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {

        if(!Utils.isValidString(etN.getText().toString()) || !Utils.isValidString(etR.getText().toString())) {
            return "Both values are needed for computation";
        } else {
            n = Integer.valueOf(etN.getText().toString());
            r = Integer.valueOf(etR.getText().toString());
            //place more checks here as needed
            if (n < r) {
                return "n must be larger than r";
            } else {
                return "";
            }
        }
    }

    @Override
    public String calculate() {

        BigInteger result = SRC_Calc_Type.BigCombination(n, r);

        return result.toString();

    }
}
