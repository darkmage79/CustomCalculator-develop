package erm.customcalculator.fragments;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.widget.EditText;

import java.math.BigInteger;

import erm.customcalculator.R;
import erm.customcalculator.classes.ClipboardManager;
import erm.customcalculator.classes.HistoryManager;
import erm.customcalculator.classes.Utils;
import java.util.Arrays;

/**
 * Created by Logan on 1/31/2016.
 * Base class to extend from
 */
public abstract class CalcBase extends Fragment {
    public static double NEWTON_GRAV_CONSTANT = 6.674 * (Math.pow(10, -11));

    public abstract String getNameOfCalculation();


    public abstract void clearPage();

    /**
     * Only return the message if the form is missing something / incorrect;
     *
     * @return
     */
    public abstract String returnMessageIfBadFormData();

    /**
     * Just calculate the formula
     *
     * @return
     */
    public abstract String calculate() throws Exception;

    /**
     * This is what will be called when the user presses the FAB
     */
    public void calculateAndDisplay() {
        String msg = returnMessageIfBadFormData();

        if (!Utils.isValidString(msg)) {
            try {
                displayResult(getNameOfCalculation(), calculate());
            } catch (Exception e) {
                throwFormError(e.getMessage());
            }
        } else {
            throwFormError(msg);
        }
    }

    public void displayResult(String nameOfResult, final String result) {
        //show popup with option to copy to clipboard
        new AlertDialog.Builder(getActivity())
                .setTitle("Result")
                .setMessage(result)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNeutralButton(getString(R.string.copy), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ClipboardManager.setClipboard(getActivity(), result);
                        Snackbar.make(getView(), getString(R.string.copied_to_cb), Snackbar.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                })
                .show();

        logResult(nameOfResult, result);
    }

    public void throwFormError(String error) {
        //Toast.makeText(getActivity(),error,Toast.LENGTH_LONG).show();
        Snackbar.make(getView(), error, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void logResult(String nameOfResult, String result) {
        //log the result for  a history section (would be really nice)
        HistoryManager hm = new HistoryManager(getActivity());
        hm.add(nameOfResult, result);

    }

    public void showHistory(){
        HistoryManager hm = new HistoryManager(getActivity());
        hm.showHistoryPopup();
    }

    //** Helper Methods for subclasses **//
    public BigInteger getBigIntegerFromEditText(EditText et) {
        if (Utils.isValidString(et.getText().toString())) {
            return new BigInteger(et.getText().toString());
        } else {
            return new BigInteger("0");
        }
    }

    public double getDouble(EditText et){
        if(!isEmpty(et)){
            return Double.parseDouble(et.getText().toString());
        } else {
            return 0;
        }
    }

    public boolean isEmpty(EditText et){
        return !Utils.isValidString(et.getText().toString());
    }


    double dblListValues, mean, median, mode, variance, standard_deviation;

    public double getMean(String[] listOfNums){
        double total=0;
        for(int i=0; i < listOfNums.length; i++){
             dblListValues = Double.parseDouble(listOfNums[i]);
             total += dblListValues;
        }

        mean = total / listOfNums.length;
        return mean;
    }
    public double getMedian(String[] listOfNums){ // TODO get this one working
        Arrays.sort(listOfNums);
        if(listOfNums.length%2 == 0){
            //median = (double)listOfNums[listOfNums.length/2] + (listOfNums.length/2 - 1)/2;
        }
        else
            median = listOfNums.length/2;

        return dblListValues;
    }
    public double getMode(String[] listOfNums){ // TODO get this one working

        for(int i=0; i < listOfNums.length; i++){
            dblListValues = Double.parseDouble(listOfNums[i]);
        }
        Arrays.sort(listOfNums);

        if(listOfNums.length % 2 == 0){
            //indexA = (listOfNums.length - 1) / 2;
            //mode = (listOfNums[dblListValues/2] + (double))
        }
        mode = listOfNums.length;
        return mode;
    }
    public double getStandardDeviation(String[] listOfNums){ // TODO get this one working

        for(int i=0; i < listOfNums.length; i++){
            dblListValues = Double.parseDouble(listOfNums[i]);
        }
        return dblListValues;
    }
    public double getVariance(String[] listOfNums){ // TODO get this one working

        for(int i=0; i < listOfNums.length; i++){
            dblListValues = Double.parseDouble(listOfNums[i]);
        }
        return dblListValues;
    }
    public double getSum(String[] listOfNums) {
        double total=0;
        for (int i = 0; i < listOfNums.length; i++) {
            dblListValues = Double.parseDouble(listOfNums[i]);
            total += dblListValues;
        }
        return total;
    }
}
