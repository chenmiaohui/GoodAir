package air.chenmh.com.util;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
/**
 * 流动的文字
 * Created by 陈苗辉 on 2017/4/22.
 */
public class flowTextView extends View{
    private static final float BASE_SQUARE_UNIT = 72f;
    private String mText = "FUCK";
    private Paint mPaint = new Paint();
    private float mTextWeight = 2;
    private int mTextColor = Color.BLACK;
    private float mTextSize = BASE_SQUARE_UNIT;
    private float mScaleFactor = 1.0f;
    private int mDuration = 3000;
    private float mShadowDy = 0;
    private ArrayList<float[]> mDatas;
    private Type mType = Type.SINGLE;
    private ObjectAnimator mSvgAnimator;
    public enum Type {
        SINGLE, MULTIPLY
    }
    public flowTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mTextColor);
        mPaint.setStrokeWidth(mTextWeight);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            setLayerType(LAYER_TYPE_SOFTWARE, mPaint);
        }
    }

    public void setTextColor(int color){
        mTextColor = color;
        mPaint.setColor(mTextColor);
    }
    public void setTextWeight(int weight){
        mTextWeight = weight ;
        mPaint.setStrokeWidth(mTextWeight);
    }
    public void setTextSize(int size){
        mTextSize = size;
        mScaleFactor = mTextSize/BASE_SQUARE_UNIT;
    }
    public void setDuration(int duration){
        mDuration = duration;
    }
    public void setPaintType(Type type){
        mType = type;
    }
    public void setShadow(int radius, int dx, int dy, int color){
        mShadowDy = dy;
        mPaint.setShadowLayer(radius, dx, dy, color);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec),measureHeight(heightMeasureSpec));
    }

    public void init(String text){
        if (text == null||text.length()==0){
            return;
        }
        requestLayout();
        invalidate();
        mText = text;
//        mDatas = Ma
        mSvgAnimator = ObjectAnimator.ofFloat(this, "phase", 0.0f, 1.0f).setDuration(mDuration);
        mSvgAnimator.start();
    }

    private int measureHeight(int heightMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            // We were told how big to be
            result = specSize;
        } else {
            // Text wight(stoke width) may cause it a litter bigger
            result = (int) (BASE_SQUARE_UNIT * mScaleFactor) + getPaddingTop()
                    + getPaddingBottom() + (int) (mTextWeight * 2) + (int) mShadowDy;
            if (specMode == MeasureSpec.AT_MOST) {
                // Respect AT_MOST value if that was what is called for by measureSpec
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureWidth(int widthMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            // We were told how big to be
            result = specSize;
        } else {
            // Measure the text
            result = (int) (mText.length() * BASE_SQUARE_UNIT * mScaleFactor + getPaddingLeft()
                    + getPaddingRight() + mTextWeight * 2);
            if (specMode == MeasureSpec.AT_MOST) {
                // Respect AT_MOST value if that was what is called for by measureSpec
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private Object lock = new Object();
    private ArrayList<Path> mPath = new ArrayList<>();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPath==null){
            return;
        }
        synchronized (lock){
            for (int i=0;i<mPath.size();i++){
                canvas.drawPath(mPath.get(i),mPaint);
            }
        }
    }

}
