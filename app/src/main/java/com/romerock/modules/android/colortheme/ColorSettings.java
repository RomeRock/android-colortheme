package com.romerock.modules.android.colortheme;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.romerock.modules.android.colortheme.Adapters.CustomPagerAdapter;
import com.romerock.modules.android.colortheme.Adapters.RecyclerViewAdapter;
import com.romerock.modules.android.colortheme.Interfaces.ItemClickInterface;
import com.romerock.modules.android.colortheme.Model.ItemSettings;
import com.romerock.modules.android.colortheme.Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.romerock.modules.android.colortheme.Utilities.Utilities.getThemePreferences;


public class ColorSettings extends AppCompatActivity {

    private final String TAG = "TIP-CALCULATOR";
    @BindView(R.id.recyclerColors)
    RecyclerView recyclerColors;
    @BindView(R.id.toolbarback)
    Toolbar toolbarback;
    @BindView(R.id.tittle)
    TextView tittle;

    View.OnClickListener onClickListener;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private boolean allThemes = false;
    private int TWEET_COMPOSER_REQUEST_CODE = 106;
    private int FACEBOOK_REQUEST_CODE = 64207;
    private AlertDialog alertDialog;
    private CustomPagerAdapter adapter;
    private ViewPager viewPager;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor ed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Utilities.getThemePreferences(getApplication()));
        setContentView(R.layout.activity_color_settings);
        sharedPref = getSharedPreferences(getString(R.string.preferences_name), MODE_PRIVATE);

        color();
    }
    private void setProVersion(){
        color();
    }


    protected void color() {
        SharedPreferences sharedPrefs = getSharedPreferences(getString(R.string.preferences_name), MODE_PRIVATE);
        Window window = this.getWindow();
        Utilities.colorStatusBar(getApplication(), window);
        ButterKnife.bind(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerColors);

        List<ItemSettings> itemsData = new ArrayList<ItemSettings>(7);
        try {
            if (sharedPrefs.getBoolean(getString(R.string.preferences_full),false)) {
                allThemes = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        itemsData.add(new ItemSettings("BLUE# ", R.drawable.img_blue, true, sharedPrefs.getString(getString(R.string.preferences_theme_tittle), "").toUpperCase().contains("BLUE") ? true : false));
        itemsData.add(new ItemSettings("ORANGE# ", R.drawable.img_orange, true, sharedPrefs.getString(getString(R.string.preferences_theme_tittle), "").toUpperCase().contains("ORANGE") ? true : false));
        itemsData.add(new ItemSettings("GREEN# ", R.drawable.img_green, allThemes, sharedPrefs.getString(getString(R.string.preferences_theme_tittle), "").toUpperCase().contains("GREEN") ? true : false));
        itemsData.add(new ItemSettings("PINK# ", R.drawable.img_pink, allThemes, sharedPrefs.getString(getString(R.string.preferences_theme_tittle), "").toUpperCase().contains("PINK") ? true : false));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(itemsData, new ItemClickInterface() {
            @Override
            public void onItemClicked(View view, int position, String code) {
                SharedPreferences sharedPrefs = getSharedPreferences(getString(R.string.preferences_name), MODE_PRIVATE);
                SharedPreferences.Editor ed = sharedPrefs.edit();
                String nameTheme="";
                switch (position) {
                    default:
                    case 0:
                        ed.putString(getString(R.string.preferences_theme_tittle), "BLUE");
                        nameTheme="Blue";
                        ed.commit();
                        setTheme(getThemePreferences(getApplication()));
                        finish();
                        break;
                    case 1:
                        ed.putString(getString(R.string.preferences_theme_tittle), "ORANGE");
                        nameTheme="Orange";
                        ed.commit();
                        setTheme(getThemePreferences(getApplication()));
                        finish();
                        break;
                    case 2:
                        if (!allThemes)
                            removeAds();
                        else {
                            ed.putString(getString(R.string.preferences_theme_tittle), "GREEN");
                            nameTheme="Green";
                        }
                        break;
                    case 3:
                        if (!allThemes)
                            removeAds();
                        else {
                            nameTheme="Pink";
                            ed.putString(getString(R.string.preferences_theme_tittle), "PINK");
                        }
                        break;
                }
                showToast(nameTheme);
                if (allThemes) {
                    ed.commit();
                    setTheme(getThemePreferences(getApplication()));
                    finish();
                }
            }

        });
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @OnClick(R.id.toolbarback)
    public void onClick() {
        finish();

    }

    private void showToast(String tittle) {
        Toast.makeText(ColorSettings.this, getString(R.string.settings_option_scheme_change, tittle), Toast.LENGTH_SHORT).show();
    }

    public void removeAds() {
        AlertDialog.Builder builder;
        View view;
        LayoutInflater inflater;
        builder = new AlertDialog.Builder(ColorSettings.this);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        builder.setCancelable(true);
        view = inflater.inflate(R.layout.pop_up_full, null);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        adapter = new CustomPagerAdapter(ColorSettings.this);
        view.findViewById(R.id.popUpFullBoton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (alertDialog != null && alertDialog.isShowing()) {
                    alertDialog.dismiss();
                }
                ed = sharedPref.edit();
                if (sharedPref.getBoolean(getString(R.string.preferences_full),false)){
                    ed.putBoolean(getString(R.string.preferences_full),false);
                }else{
                    ed.putBoolean(getString(R.string.preferences_full),true);
                }
                ed.commit();
                color();

            }
        });
        view.findViewById(R.id.popUpFullBoton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (alertDialog != null && alertDialog.isShowing()) {
                    alertDialog.dismiss();
                }

            }
        });

        viewPager.setAdapter(adapter);
        builder.setView(view);
        builder.create();
        alertDialog = builder.show();
        Utilities.autoPlay(viewPager, adapter, 0);
    }



}
