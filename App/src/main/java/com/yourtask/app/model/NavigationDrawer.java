package com.yourtask.app.model;

import android.content.Context;

import com.yourtask.app.R;

public class NavigationDrawer {
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mBoard;

    public NavigationDrawer(){

    }

    public String[] getBoardValues(Context context){
        return context.getResources().getStringArray(R.array.state);
    }

    public CharSequence getDrawerTitle() {
        return mDrawerTitle;
    }

    public CharSequence getTitle() {
        return mTitle;
    }
}
