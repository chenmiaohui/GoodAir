package air.chenmh.com.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import air.chenmh.com.R;
import air.chenmh.com.util.flowTextView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class Welcom extends AppCompatActivity {

    @Bind(R.id.welcome_img)
    ImageView mImg;
    @Bind(R.id.flow_text)
    flowTextView mFlowText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        //流动的文字的属性
        mFlowText.setTextWeight(4);
        mFlowText.setTextColor(Color.BLACK);
        mFlowText.setTextSize(30);
        mFlowText.setDuration(3000);//流动时间
        mFlowText.setPaintType(flowTextView.Type.SINGLE);
        mFlowText.setShadow(2,2,2,Color.GRAY);
        mFlowText.init("CHEN MIAO HUI");
        //图片三秒后跳转到登录页面
        mImg.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcom.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
