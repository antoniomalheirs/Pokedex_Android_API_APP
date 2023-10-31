package com.example.pokedexapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

public class CarrosselPAdapter extends PagerAdapter {

    private Context context;
    private int[] imageIds = {R.layout.banner_generation1, R.layout.banner_generation2, R.layout.banner_generation3};

    public CarrosselPAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int layoutId = imageIds[position];
        View layout = inflater.inflate(layoutId, collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}

