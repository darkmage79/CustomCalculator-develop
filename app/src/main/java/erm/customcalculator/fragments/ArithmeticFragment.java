package erm.customcalculator.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import erm.customcalculator.R;
import erm.customcalculator.classes.Utils;

/**
 * Created by Logan on 1/31/2016.
 */
public class ArithmeticFragment extends CalcBase {

    private enum Arithmetic {
        ADD, SUBTRACT, MULTIPLY, DIVIDE;

        public static Arithmetic getArithmeticByString(String str) {
            str.toLowerCase().trim();
            if (str.equals("+")) {
                return ADD;
            } else if (str.equals("-")) {
                return SUBTRACT;
            } else if (str.equals( "/")) {
                return DIVIDE;
            } else if (str.equals("x")) {
                return MULTIPLY;
            }
            return ADD;
        }
    }

    EditText mValue1, mValue2;
    Spinner mOptions;

    public ArithmeticFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = GatherViews(inflater, container);


        return v;
    }

    private View GatherViews(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_arithmetic, container,
                false);
        mValue1 = (EditText) v.findViewById(R.id.value1);
        mValue2 = (EditText) v.findViewById(R.id.value2);
        mOptions = (Spinner) v.findViewById(R.id.options);


        return v;
    }


    @Override
    public String getNameOfCalculation() {
        return getString(R.string.arithmetic);
    }

    @Override
    public void clearPage() {
        mValue1.setText("");
        mValue2.setText("");
    }

    @Override
    public String returnMessageIfBadFormData() {
        if (!Utils.isValidString(mValue1.getText().toString()) || !Utils.isValidString(mValue2.getText().toString())) {
            return "Both values required for calculation";
        }
        return "";
    }

    @Override
    public String calculate() throws Exception {
        Arithmetic eArithmetic = Arithmetic.getArithmeticByString(mOptions.getSelectedItem().toString());

            double value1 = Double.parseDouble(mValue1.getText().toString());
            double value2 = Double.parseDouble(mValue2.getText().toString());


            if (eArithmetic == Arithmetic.ADD) {
                return String.valueOf(value1+value2);
            } else if (eArithmetic == Arithmetic.SUBTRACT) {
                return String.valueOf(value1-value2);
            } else if (eArithmetic == Arithmetic.MULTIPLY) {
                return String.valueOf(value1*value2);
            } else if (eArithmetic == Arithmetic.DIVIDE) {
                return String.valueOf(value1/value2);
            }

            return "Error on computation";

    }
}
