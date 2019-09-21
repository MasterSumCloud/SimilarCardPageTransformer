package com.example.similarcardpagetransformer.transformer;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/**
 * author: eagle
 * created on: 2019-09-16 13:29
 * description:
 */
public class CardPageTransformer implements ViewPager.PageTransformer {
    private ViewPager mCurrentViewPager;

    private static final float CENTER_PAGE_SCALE = 0.85f;

    //页面显示限制 一般为mCurrentViewPager.getOffscreenPageLimit()   PS:特别提示  如果这样用需要再外面设置 否则不显示
    private int mOffscreenPageLimit;

    public CardPageTransformer(ViewPager viewPager) {
        this.mCurrentViewPager = viewPager;
        this.mOffscreenPageLimit = mCurrentViewPager.getOffscreenPageLimit();
    }

    @Override
    public void transformPage(@NonNull View page, float position) {

        if (position > -1 && position < 0) {
            float rotation = position * 30;
            page.setRotation(rotation);
            page.setAlpha((position * position * position + 1));
        } else if (position > mOffscreenPageLimit - 1) {
            page.setAlpha((float) (1 - position + Math.floor(position)));
        } else {
            page.setRotation(0);
            page.setAlpha(1);
        }

        //对对应页面设置缩放比例
        if (position == 0) {
            page.setScaleX(CENTER_PAGE_SCALE);
            page.setScaleY(CENTER_PAGE_SCALE);
        } else {
            float scaleFactor = Math.min(CENTER_PAGE_SCALE - position * 0.1f, CENTER_PAGE_SCALE);
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        }

        //针对显示的 进行偏移 需要其他样式 修改这个
        if (position >= 0) {
            //例子 向下 具体根据你的需求来定义
            page.setTranslationY(120 * position);
            page.setTranslationX(-page.getWidth() * position);
            //例子 向上
//            page.setTranslationY(-120 * position);
//            page.setTranslationX(-page.getWidth() * position);
            //例子 向左
//            page.setTranslationY(0);
//            page.setTranslationX(-page.getWidth() * position - 100 * position);
            //例子 向右
//            page.setTranslationY(0);
//            page.setTranslationX(-page.getWidth() * position + 100 * position);

        }
        //超出部分一律不显示
        if (position >= mOffscreenPageLimit || position <= -1) {
            page.setVisibility(View.GONE);
        } else {
            page.setVisibility(View.VISIBLE);
        }
    }


}
