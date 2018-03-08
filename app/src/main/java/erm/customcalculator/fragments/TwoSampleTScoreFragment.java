package erm.customcalculator.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import erm.customcalculator.R;

/**
 * Created by Logan on 3/3/2018.
 */

public class TwoSampleTScoreFragment extends CalcBase {

    public TwoSampleTScoreFragment() {
    }

    EditText etMass1, etMass2, etForce;
    double mass1, mass2, force;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_distancebetweenobjects, container,
                false);
        etMass1 = v.findViewById(R.id.value_mass1);
        etMass2 = v.findViewById(R.id.value_mass2);
        etForce = v.findViewById(R.id.value_gravitational_force);

        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.distance_between_objects);
    }

    @Override
    public void clearPage() {
        etMass1.setText("");
        etMass2.setText("");
        etForce.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {
        if (isEmpty(etMass1) || isEmpty(etMass2) || isEmpty(etForce)) {
            return "All values required for computation";
        } else {
            mass1 = getDouble(etMass1);
            mass2 = getDouble(etMass2);
            force = getDouble(etForce);

            return "";
        }
    }

    @Override
    public String calculate() throws Exception {
        return String.valueOf(Math.sqrt(NEWTON_GRAV_CONSTANT * mass1 * mass2 / force));
    }
}
