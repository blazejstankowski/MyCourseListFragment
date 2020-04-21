package com.example.mycourselistfragment.ScreenUlility;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

public class ScreenUlitity {
    private Activity activity;
    private float dpWidth;
    private float dpHeight;

    public ScreenUlitity(Activity activity) {
        this.activity = activity;

        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();

        display.getMetrics(outMetrics);
        float density = activity.getResources().getDisplayMetrics().density;
        dpHeight = outMetrics.heightPixels / density;
        dpWidth = outMetrics.widthPixels / density;
    }

    public float getDpWidth() {
        return dpWidth;
    }

    public float getDpHeight() {
        return dpHeight;
    }

}
