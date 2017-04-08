package com.example.lidya.the_senior_knowlege;

/**
 * Created by YanruFish on 4/8/2017.
 */

public class ClassCategoryItem {
    private String titleAbbr, titleFull;

    public ClassCategoryItem(String titleAbbr, String titleFull) {
        this.titleAbbr = titleAbbr;
        this.titleFull = titleFull;
    }

    public String getTitleAbbr() {
        return titleAbbr;
    }

    public String getTitleFull() {
        return titleFull;
    }

    public void setTitleAbbr(String titleAbbr) {
        this.titleAbbr = titleAbbr;
    }

    public void setTitleFull(String titleFull) {
        this.titleFull = titleFull;
    }
}
