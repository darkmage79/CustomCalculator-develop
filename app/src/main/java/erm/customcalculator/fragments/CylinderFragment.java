package erm.customcalculator.fragments;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import erm.customcalculator.R;

/**
 * Created by Owner on 3/1/2018.
 */

public class CylinderFragment extends CalcBase {

    public CylinderFragment() {}

    AppCompatEditText etNumbers;

    double dblNumbers;
    double[] lstNumbers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_statistics, container,
                false);
        etNumbers = v.findViewById(R.id.value_numbers);

        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.statistics);
    }

    @Override
    public void clearPage() {
        etNumbers.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {

        if (isEmpty(etNumbers)) {
            return "All values are needed for computation";
        } else {
            dblNumbers = getDouble(etNumbers);
            return "";
        }
    }

    @Override
    public String calculate() throws Exception {

        return String.valueOf(dblNumbers); //TODO HARDCODE A LIST OF NUMBERS TO TEST WITH!?
    }
}
