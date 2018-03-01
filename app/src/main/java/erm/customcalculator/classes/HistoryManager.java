package erm.customcalculator.classes;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import erm.customcalculator.adapters.HistoryAdapter;

import java.util.ArrayList;

import erm.customcalculator.R;

/**
 * Created by Logan on 2/2/2016.
 */
public class HistoryManager {
    public static final String HISTORY_SEPARATOR = "&";
    public static final String HISTORY_KV_SEPARATOR = "~";
    private static final String PREFERENCE_NAME = "HistoryData";
    private static final String HISTORY_KEY = "HistoryKey";
    Context context;

    public HistoryManager(Context context) {
        this.context = context;
    }

    public void add(String formula, String value) {


        final SharedPreferences settings = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = settings.edit();

        String history = settings.getString(HISTORY_KEY, "");

        if (history.length() > 0) {
            history += HISTORY_SEPARATOR + formula + HISTORY_KV_SEPARATOR + value;
        } else {
            history += formula + HISTORY_KV_SEPARATOR + value;
        }

        editor.putString(HISTORY_KEY, history);


        editor.commit();
    }

    public void deleteHistory() {
        final SharedPreferences settings = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = settings.edit();

        editor.putString(HISTORY_KEY, "");


        editor.commit();
    }

    public ArrayList<String> getHistory() {
        final SharedPreferences settings = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE);

        String history = settings.getString(HISTORY_KEY, "");
        String[] lHistory = history.split(HISTORY_SEPARATOR);
        ArrayList<String> arrHistory = new ArrayList<String>();

        if(!Utils.isValidString(history) || lHistory.length <=0){
            return null;
        }

        for (int i = lHistory.length - 1; i >= 0; i--) {
            arrHistory.add(lHistory[i]);
        }

        return arrHistory;

    }

    public void showHistoryPopup() {

        ArrayList<String> list = getHistory();
        if (list==null||list.size() <= 0) {
            Toast.makeText(context, "No history to display", Toast.LENGTH_LONG).show();
            return;
        }

        AlertDialog.Builder builderSingle = new AlertDialog.Builder(context);
        builderSingle.setIcon(R.drawable.main_image);
        builderSingle.setTitle("History");

        final HistoryAdapter arrayAdapter = new HistoryAdapter(
                context,
                getHistory());

        builderSingle.setNegativeButton(
                "Clear History",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteHistory();
                        Toast.makeText(context, "History Cleared", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });
        builderSingle.setPositiveButton(
                "Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        builderSingle.setAdapter(
                arrayAdapter, null
        );
        builderSingle.show();
    }

}
