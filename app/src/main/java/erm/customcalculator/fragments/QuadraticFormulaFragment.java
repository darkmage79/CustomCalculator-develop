package erm.customcalculator.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import erm.customcalculator.R;

/**
 * Created by Logan on 2/2/2016.
 */
public class QuadraticFormulaFragment extends CalcBase {

    public QuadraticFormulaFragment() {
    }

    EditText etA, etB, etC;
    double a, b, c;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_quadraticformula, container,
                false);
        etA = (EditText)v.findViewById(R.id.value_a);
        etB = (EditText)v.findViewById(R.id.value_b);
        etC = (EditText)v.findViewById(R.id.value_c);

        return v;
    }

    @Override
    public String getNameOfCalculation() {
        return getString(R.string.quadratic_formula);
    }

    @Override
    public void clearPage() {
        etA.setText("");
        etB.setText("");
        etC.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {
        if (isEmpty(etA) || isEmpty(etB) || isEmpty(etC)) {
            return "All values required for computation";
        } else {
            a = getDouble(etA);
            b = getDouble(etB);
            c = getDouble(etC);

            return "";
        }
    }

    @Override
    public String calculate() throws Exception {
        String positive =  String.valueOf((-b+Math.sqrt(Math.pow(b,2)-(4*a*c)))/(2*a));
        String negative = String.valueOf((-b-Math.sqrt(Math.pow(b,2)-(4*a*c)))/(2*a));
        return positive + ", " + negative;
    }
}
