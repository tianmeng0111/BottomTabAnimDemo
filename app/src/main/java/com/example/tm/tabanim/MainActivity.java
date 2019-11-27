package com.example.tm.tabanim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout tab1;
    private LinearLayout tab2;
    private LinearLayout tab3;
    private LinearLayout tab4;

    private int currentNum ;//1-4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_to_second:
                        startActivity(new Intent(MainActivity.this, Main2Activity.class));
                        return true;
                }
                return false;
            }
        });

        tab1 = (LinearLayout) findViewById(R.id.tab1);
        tab2 = (LinearLayout) findViewById(R.id.tab2);
        tab3 = (LinearLayout) findViewById(R.id.tab3);
        tab4 = (LinearLayout) findViewById(R.id.tab4);

        initData();

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }

    private void initData(){

        tab1.setSelected(true);
        startAnim(tab1);
        currentNum= 1;


        tab1.setOnClickListener(listener);
        tab2.setOnClickListener(listener);
        tab3.setOnClickListener(listener);
        tab4.setOnClickListener(listener);

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (currentNum){
                case 1:
                    tab1.setSelected(false);
                    overAnim(tab1);
                    break;
                case 2:
                    tab2.setSelected(false);
                    overAnim(tab2);
                    break;
                case 3:
                    tab3.setSelected(false);
                    overAnim(tab3);
                    break;
                case 4:
                    tab4.setSelected(false);
                    overAnim(tab4);
                    break;

            }

            switch (v.getId()){
                case R.id.tab1:
                    tab1.setSelected(true);
                    startAnim(tab1);
                    currentNum = 1;
                    break;
                case R.id.tab2:
                    tab2.setSelected(true);
                    startAnim(tab2);
                    currentNum = 2;
                    break;
                case R.id.tab3:
                    tab3.setSelected(true);
                    startAnim(tab3);
                    currentNum = 3;
                    break;
                case R.id.tab4:
                    tab4.setSelected(true);
                    startAnim(tab4);
                    currentNum = 4;
                    break;
            }
        }
    };

    public static void startAnim(View view){
        final ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, View.SCALE_X, 1f, 1.1f);
        final ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, View.SCALE_Y, 1f, 1.1f);
        final ObjectAnimator translationY = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, 0, -15);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX, scaleY, translationY);
        set.setDuration(200);
        set.start();

    }
    public static void overAnim(View view){
        final ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, View.SCALE_X, 1.1f, 1f);
        final ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, View.SCALE_Y, 1.1f, 1f);
        final ObjectAnimator translationY = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, -15, 0);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX, scaleY, translationY);
        set.setDuration(200);
        set.start();
    }



}
