package erm.customcalculator.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import erm.customcalculator.R;

/**
 * Created by Logan on 2/2/2016.
 */
public class AngleConversionFragment extends CalcBase {

    public AngleConversionFragment(){}

    EditText etAngle;
    double angle;
    String option;
    Spinner spOptions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_angle_conversion, container,
                false);
        etAngle = (EditText)v.findViewById(R.id.angle);
        spOptions = (Spinner)v.findViewById(R.id.options);
        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.degrees_radians);
    }

    @Override
    public void clearPage() {
        etAngle.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {
        if(isEmpty(etAngle)){
            return "Must provide angle for computation";
        } else {
            angle = getDouble(etAngle);
            option = spOptions.getSelectedItem().toString().trim().toLowerCase();
            return "";
        }
    }

    @Override
    public String calculate() throws Exception {
        if(option.equals("to degrees")){
            return String.valueOf(Math.toDegrees(angle));
        } else {
            return String.valueOf(Math.toRadians(angle));
        }
    }
}
