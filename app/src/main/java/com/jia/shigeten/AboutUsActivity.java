package com.jia.shigeten;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 关于我们
 * Created by JIA on 2016/11/16.
 */

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
    }

    /**
     * 控件点击事件的回调
     * @param view
     */
    public void myClick(View view){
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
