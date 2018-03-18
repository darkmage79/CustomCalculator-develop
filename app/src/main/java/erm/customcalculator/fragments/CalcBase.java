package erm.customcalculator.fragments;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.widget.EditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.math.BigInteger;

import erm.customcalculator.R;
import erm.customcalculator.classes.ClipboardManager;
import erm.customcalculator.classes.HistoryManager;
import erm.customcalculator.classes.Utils;
import java.util.Arrays;
import java.lang.Math;

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
        LayoutInflater inflater = getActivity().getLayoutInflater();
        //show popup with option to copy to clipboard
        new AlertDialog.Builder(getActivity())
                .setTitle("Result")
                .setMessage(result)
                //Set null as parent view because its going in the dialog layout
                .setView(inflater.inflate(R.layout.fragment_displayresult, null))
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


    double dblListValues;

    public double getMean(String[] listOfNums){ //DONE
        double mean, total=0;
        for(int i=0; i < listOfNums.length; i++){
             dblListValues = Double.parseDouble(listOfNums[i]);
             total += dblListValues;
        }

        mean = total / listOfNums.length;
        return mean;
    }
    public double getMedian(String[] listOfNums){ // TODO get this one working ///////////////////
        double median;
        double part1 = Double.parseDouble(listOfNums[listOfNums.length/2] + listOfNums[listOfNums.length/2 - 1]);

        Arrays.sort(listOfNums);

        if(listOfNums.length%2 == 0){
            median = part1/2;
        }else
            median = Double.parseDouble(listOfNums[listOfNums.length/2]);
        return median;
    }
    public double getMode(String[] listOfNums){ // TODO get this one working //////////////////////
        double mode = 0;
        /*
        2 variables: mode and modeCount. You should sort the array first,
        then in the only for loop, check each index against its previous index.
        If they are equal, add 1 to count, if not, check if the current count is
        greater than modeCount, if so set modeCount to count and set mode to the
        current index value. Then set count to 0 :)
         */
        return 0;
    }
    public double getSampleStdDev(String[] listOfNums){
        double sample_stddev = 0;
        double mean = getMean(listOfNums);
        for(int i=0; i < listOfNums.length; i++){
            sample_stddev += Math.sqrt((Math.pow(i - mean, 2))/(listOfNums.length-1));
        }
        return sample_stddev;
    }
    public double getSampleVariance(String[] listOfNums){
        double sampleVariance = 0;
        double mean = getMean(listOfNums);

        for(int i=0; i < listOfNums.length; i++){
            dblListValues = Double.parseDouble(listOfNums[i]);
            sampleVariance += Math.pow(dblListValues - mean, 2);
        } //The problem is that it is squaring the mean and not i - mean

        return sampleVariance / (listOfNums.length - 1);
    }
    public double getPopulationStdDev(String[] listOfNums){
        double pop_stddev = 0;
        double mean = getMean(listOfNums);
        for(int i=0; i < listOfNums.length; i++){
            dblListValues = Double.parseDouble(listOfNums[i]);
            pop_stddev += Math.sqrt((Math.pow(dblListValues - mean, 2))/(listOfNums.length));
        }
        return pop_stddev;
    }
    public double getPopulationVariance(String[] listOfNums){
        double variance = 0;
        double mean = getMean(listOfNums);

        for(int i=0; i < listOfNums.length; i++){
            dblListValues = Double.parseDouble(listOfNums[i]);
            variance += Math.pow(dblListValues - mean, 2);
        } //The problem is that it is squaring the mean and not i - mean

        return variance / (listOfNums.length);
    }
    public double getSum(String[] listOfNums) {
        double total=0;
        for (int i = 0; i < listOfNums.length; i++) {
            dblListValues = Double.parseDouble(listOfNums[i]);
            total += dblListValues;
        }
        return total;
    }

    public double getNumberOfData(String[] listOfNums){
        return listOfNums.length;
    }

    public double population_stddev(String[] listofNums){

        return dblListValues;
    }
}
