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
public class ZScoreFragment extends CalcBase {

    EditText etX, etMean, etStdDev;
    double x,mean,stdDev;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_zscore, container,
                false);
        etX = (EditText)v.findViewById(R.id.value_x);
        etMean = (EditText)v.findViewById(R.id.value_mean);
        etStdDev = (EditText)v.findViewById(R.id.value_stddev);

        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.z_score);
    }

    @Override
    public void clearPage() {
        etX.setText("");
        etMean.setText("");
        etStdDev.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {
       if(isEmpty(etX) || isEmpty(etMean)|| isEmpty(etStdDev)){
           return "All values required for computation";
       } else {
           x = getDouble(etX);
           mean = getDouble(etMean);
           stdDev = getDouble(etStdDev);
           return "";
       }
    }

    @Override
    public String calculate() throws Exception {
        return String.valueOf((x-mean)/stdDev);
    }
}
