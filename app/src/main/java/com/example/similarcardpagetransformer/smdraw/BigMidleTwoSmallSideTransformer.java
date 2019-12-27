package com.example.similarcardpagetransformer.smdraw;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.example.similarcardpagetransformer.R;


/**
 * author: eagle
 * created on: 2019-12-25 13:29
 * description:
 */
public class BigMidleTwoSmallSideTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.8f;
    private static final float MAX_SCALE = 1.0f;

    @Override
    public void transformPage(@NonNull View page, float position) {
        TextView viewById = page.findViewById(R.id.textView5);
        viewById.setText("" + position);
        //3个公式
        if (position <= 0) {
            page.setScaleY(MIN_SCALE);
        } else if (position <= 0.33f) {
            float scale = MIN_SCALE + (MAX_SCALE - MIN_SCALE) * (position / 0.333f);
            page.setScaleY(scale);
        } else if (position <= 0.66f) {
            float scale = MAX_SCALE - (MAX_SCALE - MIN_SCALE) * ((position - 0.333f) / 0.333f);
            page.setScaleY(scale);
        } else {
            page.setScaleY(MIN_SCALE);
        }

        //整个的 使用整个请出校上面的公式  兵在adapter 里面注销getPageWidth 函数
//        if (position < -1) {
//            page.setScaleY(MIN_SCALE);
//        } else if (position == 0) {
//            page.setScaleY(MAX_SCALE);
//        } else if (position <= 1) {
//            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
//            page.setScaleY(scaleFactor);
//        } else {
//            page.setScaleY(MIN_SCALE);
//        }
    }
}
