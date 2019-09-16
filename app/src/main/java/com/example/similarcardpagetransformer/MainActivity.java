package com.example.similarcardpagetransformer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.vp_cardpage);
        initData();
    }

    /**
     * 初始化假数据
     */
    private void initData() {
        ArrayList<String> listData = new ArrayList<>();
        listData.add("页面1");
        listData.add("页面2");
        listData.add("页面3");
        listData.add("页面4");
        listData.add("页面5");
        listData.add("页面6");


        CardPageAdapter cardPageAdapter = new CardPageAdapter(this,listData);
        mViewPager.setAdapter(cardPageAdapter);
    }
}
