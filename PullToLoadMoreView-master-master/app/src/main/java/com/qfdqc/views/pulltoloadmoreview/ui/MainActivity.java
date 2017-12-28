package com.qfdqc.views.pulltoloadmoreview.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.RelativeLayout;

import com.qfdqc.views.pulltoloadmoreview.R;
import com.qfdqc.views.pulltoloadmoreview.adapter.SimpleFragmentPagerAdapter;
import com.qfdqc.views.pulltoloadmoreview.utils.MyGoodsScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyGoodsScrollView.TranslucentChangedListener {

    private ArrayList<Fragment> list_fragment=new ArrayList<>();                                //定义要装fragment的列表
    private ArrayList<String> list_title=new ArrayList<>();                                //定义要装fragment的列表
    private OneFragment mOneFragment;              //热门推荐fragment
    private TwoFragment mTwoFragment;            //热门收藏fragment


    private SimpleFragmentPagerAdapter pagerAdapter;

    private ViewPager viewPager;

    private TabLayout tabLayout;
    private MyGoodsScrollView media_actions;
    private RelativeLayout relayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        media_actions= (MyGoodsScrollView) findViewById(R.id.media_actions);
        relayout= (RelativeLayout) findViewById(R.id.relayout);
        //设置透明度变化监听
        media_actions.setTranslucentChangedListener(this);
        //关联需要渐变的视图
        media_actions.setTransView(relayout, getResources().getColor(R.color.colorAccent));
        initControls();
    }


    /**
     * 初始化各控件
     */
    private void initControls() {

        //初始化各fragment
        mOneFragment = new OneFragment();
        mTwoFragment = new TwoFragment();

        //将fragment装进列表中

        list_fragment.add(mOneFragment);
        list_fragment.add(mTwoFragment);

        list_title.add("第一个页面");
        list_title.add("第二个页面");


        pagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), this,list_fragment,list_title);
//        viewPager = (ChildViewPager) findViewById(R.id.viewpager);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onTranslucentChanged(int transAlpha) {

    }
}
