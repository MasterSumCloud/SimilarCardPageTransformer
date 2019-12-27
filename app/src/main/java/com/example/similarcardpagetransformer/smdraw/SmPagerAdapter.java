package com.example.similarcardpagetransformer.smdraw;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.similarcardpagetransformer.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * author: eagle
 * created on: 2019-12-27 11:27
 * description:
 */
public class SmPagerAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<String> mDataList;

    public SmPagerAdapter(Context context, ArrayList<String> strings) {
        this.mContext = context;
        this.mDataList = strings;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = View.inflate(mContext, R.layout.item_vp_model, null);
        ImageView model = view.findViewById(R.id.iv_model);
        model.setBackgroundColor(Color.parseColor("#" + getRandColorCode()));
        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("点击了", "===》》》》" + position);
            }
        });
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    @Override
    public float getPageWidth(int position) {
        return 0.333333f;
    }


//    @Override
//    public float getPageWidth(int position) {
//        return super.getPageWidth(position);
//    }

    public static String getRandColorCode() {
        String r, g, b;
        Random random = new Random();
        r = Integer.toHexString(random.nextInt(256)).toUpperCase();
        g = Integer.toHexString(random.nextInt(256)).toUpperCase();
        b = Integer.toHexString(random.nextInt(256)).toUpperCase();
        r = r.length() == 1 ? "0" + r : r;
        g = g.length() == 1 ? "0" + g : g;
        b = b.length() == 1 ? "0" + b : b;
        return r + g + b;
    }
}
