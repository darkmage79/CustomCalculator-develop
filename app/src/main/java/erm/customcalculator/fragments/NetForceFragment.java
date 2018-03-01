package erm.customcalculator.fragments;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import erm.customcalculator.R;

/**
 * Created by Logan on 2/2/2016.
 */
public class NetForceFragment extends CalcBase {
    public NetForceFragment(){}

    EditText etMass, etAccel;
    double mass,accel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_netforce, container,
                false);
        etAccel = (EditText)v.findViewById(R.id.value_accel);
        etMass = (EditText)v.findViewById(R.id.value_mass);

        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.net_force);
    }

    @Override
    public void clearPage() {
        etAccel.setText("");
        etMass.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {
        if(isEmpty(etAccel) || isEmpty(etMass)){
            return "Both values are required for computation";
        } else {
            mass = getDouble(etMass);
            accel = getDouble(etAccel);
            return "";
        }
    }

    @Override
    public String calculate() throws Exception {
        return String.valueOf(mass*accel);
    }
}
