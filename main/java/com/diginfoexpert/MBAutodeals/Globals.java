package com.diginfoexpert.MBAutodeals;

import android.app.Application;

public class Globals extends Application {
    private static int openCount = 0; //No of times the app has been opened

    public int getOpenCount(){
        return openCount;
    }

    public void setOpenCount(int count){
        openCount = count;
    }
}
