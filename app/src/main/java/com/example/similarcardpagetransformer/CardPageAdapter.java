package com.example.similarcardpagetransformer;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private int[] mListData;
    private OnItemClickListener mOnItemClickListener;


    public CardPageAdapter(Context context, int[] listData) {
        this.mListData = listData;
        this.mContext = context;
    }


    @Override
    public int getCount() {
        return mListData == null ? 0 : mListData.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View inflate = ConstraintLayout.inflate(mContext, R.layout.item_layout, null);
        TextView tvPage = inflate.findViewById(R.id.tv_page);
        tvPage.setText("当前页面"+position);
        ImageView headView = inflate.findViewById(R.id.iv_head);
        headView.setImageResource(mListData[position]);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.OnItemClick(view, position);
                }
            }
        });

        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }


    public interface OnItemClickListener {
        void OnItemClick(View v, int position);
    }
}
