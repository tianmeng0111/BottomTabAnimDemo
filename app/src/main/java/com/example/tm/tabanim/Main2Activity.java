package com.example.tm.tabanim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    private TabAnimView ivIcon1;
    private TabAnimView ivIcon2;
    private TabAnimView ivIcon3;
    private TabAnimView ivIcon4;

    private int currentNum ;//1-4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ivIcon1 = (TabAnimView) findViewById(R.id.iv_icon_1);
        ivIcon2 = (TabAnimView) findViewById(R.id.iv_icon_2);
        ivIcon3 = (TabAnimView) findViewById(R.id.iv_icon_3);
        ivIcon4 = (TabAnimView) findViewById(R.id.iv_icon_4);

        initData();
    }

    private void initData(){
        ivIcon1.setBitmapRes(R.drawable.tubiaozhizuomoban4);
        ivIcon2.setBitmapRes(R.drawable.tubiaozhizuomoban1);
        ivIcon3.setBitmapRes(R.drawable.tubiaozhizuomoban2);
        ivIcon4.setBitmapRes(R.drawable.tubiaozhizuomoban3);

        ivIcon1.setOnClickListener(listener);
        ivIcon2.setOnClickListener(listener);
        ivIcon3.setOnClickListener(listener);
        ivIcon4.setOnClickListener(listener);

        currentNum = 1;
        ivIcon1.startAnim();
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (currentNum){
                case 1:
                    ivIcon1.resetAnim();
                    break;
                case 2:
                    ivIcon2.resetAnim();
                    break;
                case 3:
                    ivIcon3.resetAnim();
                    break;
                case 4:
                    ivIcon4.resetAnim();
                    break;

            }

            switch (v.getId()){
                case R.id.iv_icon_1:
                    ivIcon1.startAnim();
                    currentNum = 1;
                    break;
                case R.id.iv_icon_2:
                    ivIcon2.startAnim();
                    currentNum = 2;
                    break;
                case R.id.iv_icon_3:
                    ivIcon3.startAnim();
                    currentNum = 3;
                    break;
                case R.id.iv_icon_4:
                    ivIcon4.startAnim();
                    currentNum = 4;
                    break;
            }
        }
    };

}
