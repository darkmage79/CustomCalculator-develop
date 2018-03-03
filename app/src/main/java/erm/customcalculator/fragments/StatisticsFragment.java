package erm.customcalculator.fragments;

/**
 * Created by Owner on 3/1/2018.
 */


import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.math.BigInteger;
import java.lang.Object;
import erm.customcalculator.R;
import erm.customcalculator.classes.Utils;
import erm.customcalculator.original.src.SRC_Calc_Type;

/**
 * Created by Logan on 2/1/2016.
 */
public class StatisticsFragment extends CalcBase {

    public StatisticsFragment() {}

    AppCompatEditText etExpected, etObserved;
    double expected, observed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_chisquare, container,
                false);
        etExpected = v.findViewById(R.id.value_expected);
        etObserved = v.findViewById(R.id.value_observed);

        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.chisquare);
    }

    @Override
    public void clearPage() {
        etExpected.setText("");
        etObserved.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {

        if (isEmpty(etExpected) || isEmpty(etObserved)) {
            return "All values are needed for computation";
        } else {
            expected = Double.valueOf(etExpected.getText().toString());
            observed = Double.valueOf(etObserved.getText().toString());
            return "";
        }
    }

    @Override
    public String calculate() throws Exception {

        return String.valueOf(observed + "NOT DONE YET"); //TODO
    }
}

