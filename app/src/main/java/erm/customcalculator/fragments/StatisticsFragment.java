package erm.customcalculator.fragments;

/**
 * Created by Owner on 3/1/2018.
 */


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
//import android.widget.EditText;

import erm.customcalculator.R;

/**
 * Created by Logan on 2/1/2016.
 */
public class StatisticsFragment extends CalcBase {

    public StatisticsFragment() {}

    AppCompatEditText etNumbers;
    String etToString;
    String[] lstNumbers;

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

            etToString = etNumbers.getText().toString();
            lstNumbers = etToString.split(",");

            return "";
        }
    }

    @Override
    public String calculate() throws Exception {

        return String.valueOf(
                "Mean:                " + getMean(lstNumbers) + "\n" + //DONE
                "Median:              " + getMedian(lstNumbers) + "\n" +
                //"Mode:                " + getMode(lstNumbers) + "\n" +
                "Standard Deviation:  " + getStandardDeviation(lstNumbers) + "\n" +
                "Variance:            " + getVariance(lstNumbers) + "\n" +
                "Sum of Numbers:      " + getSum(lstNumbers) //DONE
        );
    }
}


/*

4,3,4

 */