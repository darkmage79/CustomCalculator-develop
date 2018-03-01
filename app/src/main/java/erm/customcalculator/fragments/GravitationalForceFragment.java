package erm.customcalculator.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import erm.customcalculator.R;

/**
 * Created by ellio on 2/2/2016.
 */
public class GravitationalForceFragment extends CalcBase {

    public GravitationalForceFragment() {
    }

    EditText etMass1, etMass2, etDistance;
    double mass1, mass2, distance;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_gravitationalforce, container,
                false);
        etMass1 = (EditText) v.findViewById(R.id.value_mass1);
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
        etMass1.setText("");
        etMass2.setText("");
        etDistance.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {
        if (isEmpty(etMass1) || isEmpty(etMass2) || isEmpty(etDistance)) {
            return "All values required for computation";
        } else {
            mass1 = getDouble(etMass1);
            mass2 = getDouble(etMass2);
            distance = getDouble(etDistance);

            return "";
        }
    }

    @Override
    public String calculate() throws Exception {
        return String.valueOf((NEWTON_GRAV_CONSTANT * mass1 * mass2) / Math.pow(distance, 2));
    }
}
