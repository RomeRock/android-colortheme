package com.romerock.modules.android.colortheme.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.romerock.modules.android.colortheme.Adapters.CustomPagerAdapter;
import com.romerock.modules.android.colortheme.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Ebricko on 05/12/2016.
 */

public class Utilities {
    public static int getThemePreferences(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preferences_name), MODE_PRIVATE);
        String themeSelected = sharedPref.getString(context.getString(R.string.preferences_theme_tittle), null);
        int theme = 0;
        if (themeSelected.contains("ORANGE")) theme = R.style.Orange;
        else if (themeSelected.contains("GREEN")) theme = R.style.Green;
        else if (themeSelected.contains("PINK")) theme = R.style.Pink;
        else if (themeSelected.contains("BLUE")) theme = R.style.AppTheme_NoActionBar;
        return theme;
    }

    public static void autoPlay(final ViewPager viewPagerSend, final CustomPagerAdapter adapterSend, final int currentCount) {
        viewPagerSend.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    if (adapterSend != null && viewPagerSend.getAdapter().getCount() > 0) {
                        int position = viewPagerSend.getCurrentItem() % adapterSend.getCount();
                        if (position >= viewPagerSend.getAdapter().getCount() - 1) {
                            viewPagerSend.setCurrentItem(0);
                        } else {
                            viewPagerSend.setCurrentItem(position + 1);
                        }

                        autoPlay(viewPagerSend, adapterSend, position + 1);
                    }
                } catch (Exception e) {
                    Log.d("Error", "Error: " + e);
                }
            }
        }, 3000);
    }

    public static void colorStatusBar(Context context, Window window){
    if (android.os.Build.VERSION.SDK_INT >= 21) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(context.getString(R.string.preferences_name), MODE_PRIVATE);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (sharedPrefs.getString(context.getString(R.string.preferences_theme_tittle), "").toUpperCase().contains("BLUE")) {
                window.setStatusBarColor(context.getResources().getColor(R.color.colorPrimaryDark));
            } else {
                if (sharedPrefs.getString(context.getString(R.string.preferences_theme_tittle), "").toUpperCase().contains("ORANGE")) {
                    window.setStatusBarColor(context.getResources().getColor(R.color.colorPrimaryDarkOrange));
                } else {
                    if (sharedPrefs.getString(context.getString(R.string.preferences_theme_tittle), "").toUpperCase().contains("GREEN")) {
                        window.setStatusBarColor(context.getResources().getColor(R.color.colorPrimaryDarkGreen));
                    } else {
                        if (sharedPrefs.getString(context.getString(R.string.preferences_theme_tittle), "").toUpperCase().contains("PINK")) {
                            window.setStatusBarColor(context.getResources().getColor(R.color.colorPrimaryDarkPink));
                        }
                    }
                }
            }
    }
}
}
