package erm.customcalculator.fragments;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import erm.customcalculator.R;
import erm.customcalculator.original.src.SRC_Calc_Type;

/**
 * Created by Logan on 2/2/2016.
 */
public class ConfidenceIntervalFragment extends CalcBase {
    EditText etSampleProportion, etCriticalValue, etSampleSize;
    double PH, CV, N;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_confidenceinterval, container,
                false);
        etSampleProportion = v.findViewById(R.id.value_sampleproportion);
        etCriticalValue = v.findViewById(R.id.value_criticalvalue);
        etSampleSize = (EditText)v.findViewById(R.id.value_samplesize);
        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.confidence_interval);
    }

    @Override
    public void clearPage() {
        etSampleProportion.setText("");
        etCriticalValue.setText("");
        etSampleSize.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {
        if (isEmpty(etSampleProportion) || isEmpty(etSampleSize) || isEmpty(etCriticalValue)) {
            return "All values required for computation";
        } else {
            PH = getDouble(etSampleProportion);
            CV = getDouble(etCriticalValue);
            N = getDouble(etSampleSize);
            return "";
        }
    }

    @Override
    public String calculate() throws Exception {
        String firstConfidenceInterval = String.valueOf(SRC_Calc_Type.CI(PH, CV, N));
        String secondConfidenceInterval = String.valueOf(SRC_Calc_Type.CII(PH, CV, N));
        return "First Confidence Interval: " + firstConfidenceInterval + ", Second Confidence Interval: " + secondConfidenceInterval;

    }
}
