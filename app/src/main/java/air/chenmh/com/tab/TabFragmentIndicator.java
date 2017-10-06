package air.chenmh.com.tab;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;

import air.chenmh.com.R;
import air.chenmh.com.activity.HomeActivity;

/**
 * 主页面上的左右滑动头布局
 * Created by 陈苗辉 on 2017/5/7.
 */
public class TabFragmentIndicator extends LinearLayout implements ViewPager.OnPageChangeListener,View.OnClickListener{

    OnTabClickListener onTabClickListener;
    Context mContext;
    ViewPager mViewPager;
    View container ;
    private View slider;
    private  int tabNum   ;
    private  int selectedPage = 0;
    private  int preSelectedPage = 0;
    private  int scrollState;
    private  final int SCROLL_STATE_PRESS = 1;
    private  final int SCROLL_STATE_UP = 2;
    private float unitWidth;
    private float currentPositionPix;
    private boolean isClick = false;
    SectionsPagerAdapter mSectionsPagerAdapter;
    private ArrayList<Class<?>> fragmentList= new ArrayList<Class<?>>();

    public TabFragmentIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public void setViewPager(ViewPager viewPager){

        viewPager.setOffscreenPageLimit(3);
        mViewPager = viewPager;
        mViewPager.setOnPageChangeListener(this);
        //设置适配器
        mSectionsPagerAdapter = new SectionsPagerAdapter(((FragmentActivity)mContext).getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    //继承Fragment的适配器的两个方法
    class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int index) {
            return Fragment.instantiate(mContext, fragmentList.get(index).getName(),null);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    //添加Fragment的页面(懒加载)
    public void addFragment(int index,Class<?> claz){
        fragmentList.add(index, claz);
        //如果滑动的数值不等于空，刷新页面
        if(mSectionsPagerAdapter!=null)
            mSectionsPagerAdapter.notifyDataSetChanged();
    }

    public void setTabContainerView(int layoutId){

        container =   LayoutInflater.from(mContext).inflate(layoutId, null);
        this.addView(container, 0);

        int height = (int) getResources().getDimension(R.dimen.tab_height);
        ViewGroup.LayoutParams params = container.getLayoutParams();
        params.height = height;
        container.setLayoutParams(params);

        if(container instanceof ViewGroup)
        {
            tabNum = ((ViewGroup)container).getChildCount();
            for(int i = 0 ;i<tabNum;i++ )
            {
                ((ViewGroup)container).getChildAt(i).setTag(i);
                ((ViewGroup)container).getChildAt(i).setOnClickListener(this);
            }
        }
    }

    public void setTabSliderView(int layoutId)
    {
        slider = LayoutInflater.from(mContext).inflate(layoutId, null);
        this.addView(slider, 1);
        setCursorWidth();
    }

    public View getIndicatorView()
    {
        return container;
    }

    /**设置cursor的宽度，并获取移动的单位长度float**/
    private void setCursorWidth(){
        int cursorWidth = getWindowWidth()/tabNum;
        unitWidth = (float)getWindowWidth()/tabNum;
        int cursorHeight = (int) getResources().getDimension(R.dimen.cursor_height);

        ViewGroup.LayoutParams params = slider.getLayoutParams();
        params.height = cursorHeight;
        params.width = cursorWidth;

        slider.setLayoutParams(params);
    }
    /**获取屏幕宽度**/
    private int getWindowWidth(){
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity)mContext).getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 点击监听
     * @param v
     */
    @Override
    public void onClick(View v) {

        final int index = (Integer) v.getTag();
        if(selectedPage==index)
        {
            onTabClickListener.onTabClick(v);
            return ;
        }
        isClick = true;
        slider.setTranslationX(0);
        TranslateAnimation animation = new TranslateAnimation(selectedPage * unitWidth , index * unitWidth, 0, 0);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.setDuration(100);
        animation.setFillEnabled(true);
        animation.setFillAfter(true);
        slider.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                mViewPager.setCurrentItem(index, true);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                slider.clearAnimation();
                slider.setTranslationX(selectedPage * unitWidth);
                isClick = false;
            }
        });


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        if(!isClick){
            if(positionOffsetPixels != 0){
                if(scrollState == SCROLL_STATE_PRESS){//手指按下的状态
                    if(selectedPage == position){//表示往左拉，相应的tab往右走
                        slider.setTranslationX(currentPositionPix + positionOffsetPixels / tabNum);
                    }else{//表示往右拉
                        slider.setTranslationX(currentPositionPix - (unitWidth - positionOffsetPixels / tabNum));
                    }
                }else if(scrollState == SCROLL_STATE_UP){//手指抬起的状态
//					System.out.println("preSelectedPage---" + preSelectedPage);
//					System.out.println("position---" + position);
                    if(preSelectedPage == position){//往左拉
                        slider.setTranslationX(currentPositionPix + positionOffsetPixels / tabNum);
                    }else{//表示往右拉
                        slider.setTranslationX(currentPositionPix - (unitWidth - positionOffsetPixels / tabNum));
                    }
                }
            }
        }
    }

    @Override
    public void onPageSelected(int position) {

        ((TextView)((ViewGroup)container).getChildAt(selectedPage)).setTextColor(this.getResources().getColor(android.R.color.black));
        ((TextView)((ViewGroup)container).getChildAt(position)).setTextColor(this.getResources().getColor(R.color.orange));
        selectedPage = position;

        //此添加的是可以左右滑动并且滑动到最左边会出现侧滑的 此处只能在主页面上有侧滑的使用，如果没有侧滑需要删除本段的代码
//        if (position == 0) {
//            HomeActivity.sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        } else {
//            HomeActivity.sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
//        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if(!isClick){
            currentPositionPix = selectedPage * unitWidth;
            scrollState = state;
            preSelectedPage = selectedPage;
        }
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener){
        this.onTabClickListener = onTabClickListener;
    }
    public interface OnTabClickListener{
        public void onTabClick(View v);
    }

}
