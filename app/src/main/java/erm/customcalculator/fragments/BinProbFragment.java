package erm.customcalculator.fragments;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.math.BigInteger;

import erm.customcalculator.R;
import erm.customcalculator.classes.Utils;
import erm.customcalculator.original.src.SRC_Calc_Type;

/**
 * Created by Logan on 2/1/2016.
 */
public class BinProbFragment extends CalcBase {

    public BinProbFragment() {
    }

    AppCompatEditText etN, etR, etP;
    int n, r;
    double probabilityOfSuccess;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_binprob, container,
                false);
        etN = (AppCompatEditText) v.findViewById(R.id.value_n);
        etR = (AppCompatEditText) v.findViewById(R.id.value_r);
        etP = (AppCompatEditText) v.findViewById(R.id.value_p);

        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.binomial_probability);
    }

    @Override
    public void clearPage() {
        etR.setText("");
        etN.setText("");
        etP.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {

        if (isEmpty(etN) || isEmpty(etR) || isEmpty(etP)) {
            return "All values are needed for computation";
        } else {
            n = Integer.valueOf(etN.getText().toString());
            r = Integer.valueOf(etR.getText().toString());
            probabilityOfSuccess = Double.valueOf(etP.getText().toString());

            //place more checks here as needed
            if (n < r) {
                return "n must be larger than r";
            } else {

                return "";
            }
        }
    }

    @Override
    public String calculate() throws Exception {
        int numberOfFailures = n - r;
        double probabilityOfFailures = 1 - probabilityOfSuccess;
        //nCr
        BigInteger nCr = SRC_Calc_Type.BigCombination(n, r);
        //p^k
        double probSuccessToNumOfSuccess = Math.pow(probabilityOfSuccess, r);
        //q^(n-k)
        double probFailureToNumOfFails= Math.pow(probabilityOfFailures,numberOfFailures);

        return String.valueOf(nCr.doubleValue() * probSuccessToNumOfSuccess * probFailureToNumOfFails);


    }
}
