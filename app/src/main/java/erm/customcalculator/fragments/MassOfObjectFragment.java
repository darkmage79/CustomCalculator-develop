package erm.customcalculator.fragments;

/**
 * Created by ellio on 2/2/2016.
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import erm.customcalculator.R;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import erm.customcalculator.R;

/**
 * Created by ellio on 2/2/2016.
 */
public class MassOfObjectFragment extends CalcBase {

    public MassOfObjectFragment() {
    }

    EditText etGF,etMass2,etDistance;
    double gf,mass2,distance;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_massofobject, container,
                false);
        etGF = (EditText)v.findViewById(R.id.value_gf);
        etMass2 = (EditText) v.findViewById(R.id.value_mass2);
        etDistance = (EditText)v.findViewById(R.id.value_distance);

        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.gravitation_force);
    }

    @Override
    public void clearPage() {
        etGF.setText("");
        etMass2.setText("");
        etDistance.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {
        if (isEmpty(etGF) || isEmpty(etMass2) || isEmpty(etDistance)) {
            return "All values required for computation";
        } else {
            gf = getDouble(etGF);
            mass2 = getDouble(etMass2);
            distance = getDouble(etDistance);

            return "";
        }
    }

    @Override
    public String calculate() throws Exception {
        double answer1 = (NEWTON_GRAV_CONSTANT * gf) * mass2;
        answer1 = answer1 / (Math.pow(distance, 2));
        answer1 = answer1 * Math.pow(distance, 2);
        answer1 = answer1 / (NEWTON_GRAV_CONSTANT * mass2);
        return String.valueOf(answer1);
    }
}

