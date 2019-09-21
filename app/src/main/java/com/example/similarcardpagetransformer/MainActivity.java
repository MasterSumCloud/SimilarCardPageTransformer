package com.example.similarcardpagetransformer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.similarcardpagetransformer.usevp.CardPageAdapter;
import com.example.similarcardpagetransformer.usevp.CardPageTransformer;
import com.example.similarcardpagetransformer.usevp.UseViewPagerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button mBtGoVpIml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtGoVpIml = findViewById(R.id.button_go_vp);

        initListener();
    }

    private void initListener() {
        mBtGoVpIml.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_go_vp:
                startActivity(new Intent(this, UseViewPagerActivity.class));
                break;
        }
    }
}
