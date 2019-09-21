package com.example.similarcardpagetransformer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.similarcardpagetransformer.transformer.CardPageTransformer;

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
        int[] listData = {R.mipmap.index1,R.mipmap.index2,R.mipmap.index3,R.mipmap.index4,R.mipmap.index5,R.mipmap.index1,R.mipmap.index2,R.mipmap.index3,R.mipmap.index4,R.mipmap.index5};

        mViewPager.setOffscreenPageLimit(3);
        CardPageAdapter cardPageAdapter = new CardPageAdapter(this, listData);
        cardPageAdapter.setOnItemClickListener(new CardPageAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View v, int position) {
                Log.d("点击测试", "点击的页面" + position);

            }
        });
        mViewPager.setPageTransformer(true, new CardPageTransformer(mViewPager));
        mViewPager.setAdapter(cardPageAdapter);

    }
}
