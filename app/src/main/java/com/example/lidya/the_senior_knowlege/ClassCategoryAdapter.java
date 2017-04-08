package com.example.lidya.the_senior_knowlege;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by YanruFish on 4/8/2017.
 */

public class ClassCategoryAdapter extends ArrayAdapter<ClassCategoryItem> {

    ArrayList<ClassCategoryItem> classCategoryItems;
    Context context;
    int resource;
    private ArrayList<ClassCategoryItem> filteredList = new ArrayList<>();

    public ClassCategoryAdapter (Context context, int resource, ArrayList<ClassCategoryItem> classCategoryItems) {
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
    public ClassCategoryItem getItem(int i) {
        return filteredList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ClassCategoryItem ClassCategoryItem = getItem(position);

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.class_category_item, null, true);
        }

        final TextView abbr = (TextView) convertView.findViewById(R.id.class_category_abbr);
        abbr.setText(ClassCategoryItem.getTitleAbbr());

        TextView full = (TextView) convertView.findViewById(R.id.class_category_full);
        full.setText(ClassCategoryItem.getTitleFull());

        CardView view = (CardView) convertView.findViewById(R.id.layout);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ClassesActivity.class);
                intent.putExtra("Category", abbr.getText().toString());
                context.startActivity(intent);
            }
        });

        return convertView;
    }

}
