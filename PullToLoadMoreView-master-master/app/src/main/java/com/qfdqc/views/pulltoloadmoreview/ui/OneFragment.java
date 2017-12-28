package com.qfdqc.views.pulltoloadmoreview.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qfdqc.views.pulltoloadmoreview.R;
import com.qfdqc.views.pulltoloadmoreview.utils.MyGoodsScrollView;
import com.qfdqc.views.pulltoloadmoreview.utils.PublicGoodsStaticClass;

public class OneFragment extends Fragment {
    View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_one, container, false);
        initView();
        return mView;
    }

    private void initView() {
        MyGoodsScrollView oneScrollView= (MyGoodsScrollView) mView.findViewById(R.id.oneScrollview);
        oneScrollView.setScrollListener(new MyGoodsScrollView.ScrollListener() {
            @Override
            public void onScrollToBottom() {

            }

            @Override
            public void onScrollToTop() {

            }

            @Override
            public void onScroll(int scrollY) {
                if (scrollY == 0) {
                    PublicGoodsStaticClass.IsTop = true;
                } else {
                    PublicGoodsStaticClass.IsTop = false;
                }
            }

            @Override
            public void notBottom() {

            }

        });
    }
}
