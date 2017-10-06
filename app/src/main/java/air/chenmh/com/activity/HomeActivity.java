package air.chenmh.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewParent;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import air.chenmh.com.R;
import air.chenmh.com.fragment.RankingFragment;
import air.chenmh.com.fragment.RealFragment;
import air.chenmh.com.fragment.SiteFragment;
import air.chenmh.com.tab.TabFragmentIndicator;

/**
 * Created by 陈苗辉 on 2017/5/6.
 */
public class HomeActivity extends SlidingFragmentActivity implements View.OnClickListener,TabFragmentIndicator.OnTabClickListener{
    public static SlidingMenu sm;
    private ViewPager mViewPager;
    private TabFragmentIndicator mTabFragmentIndicator;
    private View categoryTab;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initSlidingMenu();
        initTab();
    }

    private void initSlidingMenu() {
        setBehindContentView(R.layout.hind_frame);//侧滑隐藏
        sm = getSlidingMenu();
        sm.setMode(SlidingMenu.LEFT);
        sm.setFadeDegree(0.35f);
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);// 侧滑右边距离Fragment右边距的距离
        // 侧滑的布局
        sm.setMenu(R.layout.slidingmenu);
        View v = sm.getMenu();
    }

    private void initTab() {
        mViewPager = (ViewPager) findViewById(R.id.vp_content);
        mTabFragmentIndicator = (TabFragmentIndicator) findViewById(R.id.tabFragmentIndicator);
        mTabFragmentIndicator.addFragment(0,RealFragment.class);
        mTabFragmentIndicator.addFragment(1,SiteFragment.class);//SiteListFragment
        mTabFragmentIndicator.addFragment(2,RankingFragment.class);//RangFragment
        mTabFragmentIndicator.setTabContainerView(R.layout.home_tabindicator);
        mTabFragmentIndicator.setTabSliderView(R.layout.tab_slider);
        mTabFragmentIndicator.setOnTabClickListener(this);
        mTabFragmentIndicator.setViewPager(mViewPager);
    }

    //点击事件
    @Override
    public void onClick(View v) {
        //侧滑上的点击
    }

    @Override
    public void onTabClick(View v) {
        if((Integer)v.getTag() == 0)
        {
            categoryTab = v;
        }
    }
}
