package com.example.similarcardpagetransformer.smdraw;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.similarcardpagetransformer.R;

import java.util.ArrayList;

/**
 * author: eagle
 * created on: 2019-12-27 11:24
 * description:
 */
public class SimilarGalleryActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gallery);

        //init data
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            strings.add(String.valueOf(i));
        }
        mViewPager = findViewById(R.id.vp_similar_gallery);
        mViewPager.setPageTransformer(false, new BigMidleTwoSmallSideTransformer());
        SmPagerAdapter smPagerAdapter = new SmPagerAdapter(this, strings);
        mViewPager.setAdapter(smPagerAdapter);
    }
}
