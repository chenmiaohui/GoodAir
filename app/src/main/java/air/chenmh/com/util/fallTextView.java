package air.chenmh.com.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/**
 * 飘落的字体
 * Created by 陈苗辉 on 2017/5/12.
 */
public class fallTextView extends View{

    private int w,h; // 界面宽高
    final static int NUM = 4 ;
    int snowSpeed = 50 ; //
    int snowSize = 20;

    int x[];//坐标
    int y[];
    Paint paint;//画笔


    public fallTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 初始化
        w = context.getResources().getDisplayMetrics().widthPixels;
        h = context.getResources().getDisplayMetrics().heightPixels;

        initPaint();

        new Thread(runnable).start(); // 开启线程
    }

    public void initPaint(){
        paint = new Paint() ;

        paint.setColor(Color.RED);
        paint.setTextSize(snowSize);


        x = new int[NUM];
        y = new int[NUM];
        for(int i =0 ; i < NUM;i++){
            x[i] = (int) (Math.random()*w);
            y[i] = (int) (Math.random()*h);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        DrawLine(canvas,s, x, y, paint);

        if (s==null) {
            paint.setColor(Color.RED);
        }else{

            if (s.equals("优")) {
                paint.setColor(Color.GREEN);
            }
            if (s.equals("良")) {
                paint.setColor(Color.YELLOW);
            }
            if (s.equals("轻度污染")) {
                paint.setColor(Color.parseColor("#FF7E00"));
            }
            if (s.equals("中度污染")) {
                paint.setColor(Color.parseColor("#FF0000"));
            }
            if (s.equals("重度污染")) {
                paint.setColor(Color.parseColor("#99004C"));
            }
            if (s.equals("严重污染")) {
                paint.setColor(Color.parseColor("#7E0023"));
            }
        }

    }
    //存储的数据
    private String s ;

    public String getPollutant(){

        return s;
    }
    public void setPollutant(String s){

        this.s = s;
    }

    private void DrawLine(Canvas canvas,String s, int[] x2, int[] y2, Paint paint2) {

        if (s==null) {
            return;
        }

        for(int i =0 ; i<NUM;i++){

            canvas.drawText( s , x[i], y[i], paint);

        }
    }
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        public void run()
        {
            for(int i =0 ; i < NUM;i++)
            {
                y[i] += 3 ;
                if(y[i] > h)
                    y[i] = 0 ;
            }
            fallTextView.this.invalidate(); // 刷新
            handler.postDelayed(runnable, snowSpeed); //延迟时间
        }
    };
}
