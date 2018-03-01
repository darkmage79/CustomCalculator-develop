package erm.customcalculator.fragments;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import erm.customcalculator.R;

/**
 * Created by Logan on 2/2/2016.
 */
public class SineCosineTangentFragment extends CalcBase {

    EditText etAngle;
    Spinner spSelection;
    String selection;
    double angle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_sincostang, container,
                false);
        etAngle = (EditText)v.findViewById(R.id.angle);
        spSelection = (Spinner)v.findViewById(R.id.options);

        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.sine_cosine_tangent);
    }

    @Override
    public void clearPage() {
        etAngle.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {
        if(isEmpty(etAngle)){
            return "Must provide angle for calculation";
        } else {
            angle = getDouble(etAngle);
            selection = spSelection.getSelectedItem().toString().trim().toLowerCase();
            return "";
        }

    }

    @Override
    public String calculate() throws Exception {
        if(selection.equals("sine")){
            return String.valueOf(Math.sin(angle));
        } else if(selection.equals("cosine")){
            return String.valueOf(Math.cos(angle));
        } else if(selection.equals("tangent")){
            return String.valueOf(Math.tan(angle));
        } else {
            return String.valueOf(Math.sin(angle));
        }
    }
}
