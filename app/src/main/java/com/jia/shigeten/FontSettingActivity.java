package com.jia.shigeten;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jia.shigeten.utils.Utils;

/**
 * 字体设置
 * Created by JIA on 2016/11/16.
 */

public class FontSettingActivity extends AppCompatActivity {

    private TextView tv_example_content;                //示例内容
    private TextView tv_example_name;                   //示例标题

    private TextView tv_big,tv_mid,tv_small;
    private int fontsize;                               //当前字体大小
    private int fontsize_new;                           //预览字体大小

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fontsetting);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        initView();
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        SharedPreferences font = getSharedPreferences("font", MODE_PRIVATE);
        fontsize = font.getInt("fontsize", -1);
        fontsize_new = fontsize;
        if (fontsize == 0) tv_small.setTextColor(Color.BLUE);
        else if (fontsize == 1) tv_mid.setTextColor(Color.BLUE);
        else if (fontsize == 2) tv_big.setTextColor(Color.BLUE);
        Utils.setTextSize(this,Utils.FONT_CONTENT_TYPE,tv_example_content);
        Utils.setTextSize(this,Utils.FONT_SIGN_TYPE,tv_example_name);
    }

    /**
     * 初始化控件
     */
    private void initView() {
        tv_big = (TextView) findViewById(R.id.tv_big);
        tv_mid = (TextView) findViewById(R.id.tv_mid);
        tv_small = (TextView) findViewById(R.id.tv_small);
        tv_example_content = (TextView) findViewById(R.id.tv_example_content);
        tv_example_name = (TextView) findViewById(R.id.tv_example_name);

    }

    /**
     * 控件点击事件的回调
     * @param view
     */
    public void myClick(View view){
        switch (view.getId()){
            case R.id.back:
                setResult();
                break;
            case R.id.tv_big:
                fontsize_new = Utils.FONT_LARGE;
                resetText((TextView) view);
                tv_example_content.setTextAppearance(this,R.style.Font42);
                tv_example_name.setTextAppearance(this,R.style.Font36);
                break;
            case R.id.tv_mid:
                fontsize_new = Utils.FONT_MIDDLE;
                resetText((TextView) view);
                tv_example_content.setTextAppearance(this,R.style.Font32);
                tv_example_name.setTextAppearance(this,R.style.Font28);
                break;
            case R.id.tv_small:
                fontsize_new = Utils.FONT_SMALL;
                resetText((TextView) view);
                tv_example_content.setTextAppearance(this,R.style.Font20);
                tv_example_name.setTextAppearance(this,R.style.Font18);
                break;
        }
    }

    /**
     * 改变字体颜色
     * @param tv
     */
    private void resetText(TextView tv) {
        tv_big.setTextColor(getResources().getColor(R.color.color464646));
        tv_mid.setTextColor(getResources().getColor(R.color.color464646));
        tv_small.setTextColor(getResources().getColor(R.color.color464646));
        tv.setTextColor(Color.BLUE);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        setResult();
    }

    public void setResult(){
        if (fontsize_new != fontsize){
            SharedPreferences font = getSharedPreferences("font", MODE_PRIVATE);
            SharedPreferences.Editor edit = font.edit();
            edit.putInt("fontsize",fontsize_new);
            edit.apply();
            setResult(1);
        }
        finish();
    }
}
