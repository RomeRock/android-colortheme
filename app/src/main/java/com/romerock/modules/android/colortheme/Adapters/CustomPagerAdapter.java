package com.romerock.modules.android.colortheme.Adapters;

/**
 * Created by Ebricko on 01/01/2017.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.romerock.modules.android.colortheme.R;

public class CustomPagerAdapter extends PagerAdapter {
    private Context context;
    private int[] mImages = new int[]{
            R.drawable.img_preview_green,
            R.drawable.img_preview_pink};

    @Override
    public int getCount() {
        return mImages.length;
    }

    public CustomPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageResource(mImages[position]);

        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
}