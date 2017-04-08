package com.example.lidya.the_senior_knowlege;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by YanruFish on 4/8/2017.
 */

public class UpperLevelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upperlevel);

        ArrayList<ClassCategoryItem> items = new ArrayList<>();
        items.add(new ClassCategoryItem("CMSC", "Computer Science"));
        items.add(new ClassCategoryItem("MATH", "Mathematics"));
        final ListView listView = (ListView) findViewById(R.id.class_category_list);
        ClassCategoryAdapter classesAdapter = new ClassCategoryAdapter(this, R.layout.class_category_item, items);
        listView.setAdapter(classesAdapter);
        setListViewHeightBasedOnChildren(listView);

        NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R.id.scrollView);
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                setListViewHeightBasedOnChildren(listView);
            }
        });
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            if (listItem instanceof ViewGroup) {
                listItem.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
