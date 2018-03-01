package erm.customcalculator.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import erm.customcalculator.R;
import erm.customcalculator.classes.HistoryManager;

/**
 * Created by Logan on 2/2/2016.
 */
public class HistoryAdapter extends ArrayAdapter<String> {
    public HistoryAdapter(Context context, ArrayList<String> list){
        super(context,0,list);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String item = getItem(position);
        String name = item.split(HistoryManager.HISTORY_KV_SEPARATOR)[0];
        String value = item.split(HistoryManager.HISTORY_KV_SEPARATOR)[1];
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.history_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.name);
        TextView tvValue = (TextView) convertView.findViewById(R.id.value);
        // Populate the data into the template view using the data object
        tvName.setText(name);
        tvValue.setText(value);
        // Return the completed view to render on screen
        return convertView;
    }

}
