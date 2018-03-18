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
import java.lang.Object;
import java.util.Formatter;

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
            etToString.trim();
            lstNumbers = etToString.split(" ");

            return "";
        }
    }

    Formatter formatter = new Formatter();
    @Override
    public String calculate() throws Exception {
        String strSimpleStats = "Simple Statistics";
        String strSample = "Sample";
        String strPopulation = "Population";
        return String.valueOf(
                String.format("%50s", strSimpleStats) + "\n" + //This works
                "Mean:                       " + getMean(lstNumbers) + "\n" + //DONE
                "Median:                     " + getMedian(lstNumbers) + "\n" + //TODO
                "Mode:                       " + getMode(lstNumbers) + "\n" + //TODO
                "Sum of Numbers:             " + getSum(lstNumbers) + "\n" + //DONE
                "Number of inputs:           " + getNumberOfData(lstNumbers) + "\n" + //DONE
                String.format("%50s", strSample) + "\n" + //This works
                "Sample Std Dev:             " + getSampleStdDev(lstNumbers) + "\n" + //TODO
                "Sample Variance:            " + getSampleVariance(lstNumbers) + "\n" + //TODO sigma squared
                String.format("%50s", strPopulation) + "\n" + //This works
                "Population Standard Dev:    " + getPopulationStdDev(lstNumbers) + "\n" + //TODO sigma
                "Population Variance:        " + getPopulationVariance(lstNumbers) //DONE sigma squared
        );
    }
}