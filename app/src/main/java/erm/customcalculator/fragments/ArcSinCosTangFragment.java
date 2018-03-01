package erm.customcalculator.fragments;

/**
 * Created by Logan on 2/2/2016.
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import erm.customcalculator.R;


import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import erm.customcalculator.R;

/**
 * Created by ellio on 2/2/2016.
 */
public class ArcSinCosTangFragment extends CalcBase {

    EditText etNumber1,etNumber2;
    Spinner spSelection;
    String selection;
    double number1,number2;

    public ArcSinCosTangFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_arcsincostang, container,
                false);
        etNumber1 = (EditText)v.findViewById(R.id.value1);
        etNumber2 = (EditText)v.findViewById(R.id.value2);
        spSelection = (Spinner)v.findViewById(R.id.options);

        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.sine_cosine_tangent);
    }

    @Override
    public void clearPage() {
        etNumber1.setText("");
        etNumber2.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {
        if(isEmpty(etNumber1) || isEmpty(etNumber2)){
            return "Must provide both values for calculation";
        } else {
            number1= getDouble(etNumber1);
            number2= getDouble(etNumber2);
            selection = spSelection.getSelectedItem().toString().trim().toLowerCase();
            return "";
        }

    }

    @Override
    public String calculate() throws Exception {
        double value = number1/number2;
        if(selection.equals("arcsine")){
            return String.valueOf(Math.asin(value));
        } else if(selection.equals("arccosine")){
            return String.valueOf(Math.acos(value));
        } else if(selection.equals("arctangent")){
            return String.valueOf(Math.atan(value));
        } else {
            return String.valueOf(Math.asin(value));
        }
    }
}
