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

public class ClassesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        ArrayList<ClassItem> items = new ArrayList<>();
        if (getIntent().equals("CMSC")) {

        }
        items.add(new ClassItem("CMSC320", "Introduction to Data Science", 3, true, "An introduction to the data science pipeline, i.e., the end-to-end process of going from unstructured, messy data to knowledge and actionable insights. Provides a broad overview of several topics including statistical data analysis, basic data mining and machine learning algorithms, large-scale data management, cloud computing, and information visualization."));
        items.add(new ClassItem("CMSC330", "Organization of Programming Languages", 3, true, "The semantics of programming languages and their run-time organization. Several different models of languages are discussed, including procedural (e.g., C, Pascal), functional (e.g., ML, LISP), rule-based (e.g., Prolog), and object-oriented (e.g., C++, Smalltalk). Run-time structures, including dynamic versus static scope rules, storage for strings, arrays, records, and object inheritance are explored."));
        items.add(new ClassItem("CMSC351", "Algorithms", 3, true, "A systematic study of the complexity of some elementary algorithms related to sorting, graphs and trees, and combinatorics. Algorithms are analyzed using mathematical techniques to solve recurrences and summations."));
        items.add(new ClassItem("CMSC389N", "Special Topics in Computer Science; Introduction to PHP and Javascript", 3, false, "This course provides an introduction to the development of Web-based applications using PHP, JavaScript, MySQL/MariaDB, and Apache. The course covers fundamental programming language constructs of both PHP and JavaScript, forms, sessions, interation with MySQL/MariaDB via PHP, DOM, and JavaScript event-handling. In addition, popular JavaScript libraries (e.g., JQuery) will be overviewed."));
        items.add(new ClassItem("CMSC411", "Computer Systems Architecture", 3, true, "Input/output processors and techniques. Intra-system communication, buses, caches. Addressing and memory hierarchies. Microprogramming, parallelism, and pipelining."));
        final ListView listView = (ListView) findViewById(R.id.classes_list);
        ClassesAdapter classesAdapter = new ClassesAdapter(this, R.layout.class_item, items);
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