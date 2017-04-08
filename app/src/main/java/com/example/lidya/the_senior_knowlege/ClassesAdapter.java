package com.example.lidya.the_senior_knowlege;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by YanruFish on 4/8/2017.
 */

public class ClassesAdapter  extends ArrayAdapter<ClassItem> {

    ArrayList<ClassItem> classCategoryItems;
    Context context;
    int resource;
    private ArrayList<ClassItem> filteredList = new ArrayList<>();

    public ClassesAdapter (Context context, int resource, ArrayList<ClassItem> classCategoryItems) {
        super(context, resource, classCategoryItems);
        this.classCategoryItems = classCategoryItems;
        this.filteredList = classCategoryItems;
        this.context = context;
        this.resource = resource;
        getFilter();
    }

    @Override
    public int getCount() {
        return filteredList.size();
    }

    @Override
    public ClassItem getItem(int i) {
        return filteredList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ClassItem classItem = getItem(position);

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.class_item, null, true);
        }

        TextView name = (TextView) convertView.findViewById(R.id.class_name);
        name.setText(classItem.getName());

        TextView title = (TextView) convertView.findViewById(R.id.class_title);
        title.setText(classItem.getTitle());

        TextView credit = (TextView) convertView.findViewById(R.id.credit);
        credit.setText(""+classItem.getCredit());

        TextView permission = (TextView) convertView.findViewById(R.id.permission);
        permission.setText(classItem.isPermission() ? "Yes" : "No");

        TextView description = (TextView) convertView.findViewById(R.id.description);
        description.setText(classItem.getDescription());

        CardView view = (CardView) convertView.findViewById(R.id.layout);

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        view.setLayoutParams(layoutParams);

        return convertView;
    }
}
