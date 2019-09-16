package com.example.similarcardpagetransformer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

/**
 * author: eagle
 * created on: 2019-09-16 13:32
 * description:
 */
public class CardPageAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<String> mListData;


    public CardPageAdapter(Context context, ArrayList<String> listData) {
        this.mListData = listData;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mListData == null ? 0 : mListData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View inflate = ConstraintLayout.inflate(mContext, R.layout.item_layout, null);
        TextView tvPage = inflate.findViewById(R.id.tv_page);
        tvPage.setText(mListData.get(position));

        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
