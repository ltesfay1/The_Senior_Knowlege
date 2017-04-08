package com.example.lidya.the_senior_knowlege;

/**
 * Created by YanruFish on 4/8/2017.
 */

public class ClassItem {
    private String name, title, description;
    private int credit;
    private boolean permission;

    public ClassItem(String name, String title, int credit, boolean permission, String description) {
        this.name = name;
        this.title = title;
        this.credit = credit;
        this.description = description;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPermission() {
        return permission;
    }
}
