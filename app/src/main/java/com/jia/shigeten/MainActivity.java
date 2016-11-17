package com.jia.shigeten;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jia.shigeten.fragments.ContentFragment;
import com.jia.shigeten.utils.FragmentUtils;
import com.jia.shigeten.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Fragment> fragments;                   //页面集合
    private int lastPos;                                //上一次显示的页面位置
    private List<ImageView> ivs = new ArrayList<>();    //底部选项图片集合
    private List<View> views = new ArrayList<>();      //底部线条集合
    private int[] imgs;                                 //底部图片资源集合
    private int[] imgs_selected;                        //底部图片被选中资源集合
    private ImageView iv_icon;                          //顶部标题图片
    private TextView tv_page_title;                     //顶部标题文字

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this,WelcomeActivity.class));
        setContentView(R.layout.activity_main);
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
        initFont();
        imgs = new int[]{R.drawable.home_critic,R.drawable.home_novel,R.drawable.home_diagram,R.drawable.home_personal};
        imgs_selected = new int[]{R.drawable.home_critic_focus,R.drawable.home_novel_focus,R.drawable.home_diagram_focus,R.drawable.home_personal_focus};
        initFragment();
        setListener();
    }

    /**
     * 初始化字体大小
     */
    private void initFont() {
        SharedPreferences font = getSharedPreferences("font", MODE_PRIVATE);
        if (font.getInt("fontsize",-1) == -1){
            SharedPreferences.Editor edit = font.edit();
            edit.putInt("fontsize", Utils.FONT_MIDDLE);
            edit.apply();
        }
    }

    //返回键的标记
    private boolean canExit = false;

    /**
     * 点击返回键的回调
     */
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if (canExit) finish();
        else{
            Toast.makeText(this, "再按一次返回键退出应用", Toast.LENGTH_SHORT).show();
            canExit = true;
            new Handler().postDelayed(new Runnable() {    //两秒之内没有再次点击返回，重置标记
                @Override
                public void run() {
                    canExit = false;
                }
            },2000);
        }
    }

    /**
     * 设置监听
     */
    private void setListener() {
        findViewById(R.id.critic).setOnClickListener(this);
        findViewById(R.id.novel).setOnClickListener(this);
        findViewById(R.id.diagram).setOnClickListener(this);
        findViewById(R.id.setting).setOnClickListener(this);
    }

    /**
     * 显示指定位置的页面
     * @param position
     */
    private void showFragment(int position,String title){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.hide(fragments.get(lastPos));
        ft.show(fragments.get(position));
        ft.commit();
        if (title != null) {
            iv_icon.setVisibility(View.INVISIBLE);
            tv_page_title.setVisibility(View.VISIBLE);
            tv_page_title.setText(title);
        }else {
            tv_page_title.setVisibility(View.INVISIBLE);
            iv_icon.setVisibility(View.VISIBLE);
        }
        ivs.get(lastPos).setImageResource(imgs[lastPos]);
        views.get(lastPos).setVisibility(View.INVISIBLE);
        ivs.get(position).setImageResource(imgs_selected[position]);
        views.get(position).setVisibility(View.VISIBLE);
        lastPos = position;
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        fragments = FragmentUtils.getFragments_main();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            ft.add(R.id.frame_layout,fragments.get(i));
            ft.hide(fragments.get(i));
        }
        ft.show(fragments.get(0));
        ft.commit();
        lastPos = 0;
    }

    /**
     * 初始化控件
     */
    private void initView() {
        iv_icon = (ImageView) findViewById(R.id.iv_icon);
        tv_page_title = (TextView) findViewById(R.id.tv_page_title);
        ivs.add((ImageView) findViewById(R.id.criticimg));
        ivs.add((ImageView) findViewById(R.id.novelimg));
        ivs.add((ImageView) findViewById(R.id.diagramimg));
        ivs.add((ImageView) findViewById(R.id.settingimg));
        views.add(findViewById(R.id.critic_line));
        views.add(findViewById(R.id.novel_line));
        views.add(findViewById(R.id.diagram_line));
        views.add(findViewById(R.id.setting_line));
    }

    /**
     * 控件点击事件的回调
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.critic:
                showFragment(0,null);
                break;
            case R.id.novel:
                showFragment(1,"文章");
                break;
            case R.id.diagram:
                showFragment(2,"美图");
                break;
            case R.id.setting:
                showFragment(3,"个人中心");
                break;
        }
    }

    /**
     * 启动别的页面的返回值
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0){
            if (resultCode == 1){       //需要改变字体大小
                Log.e("--------","改变字体大小");
                changeTextSize();
            }
        }
    }

    /**
     * 改变字体大小
     */
    public void changeTextSize(){
        for (int i = 0; i < 3; i++) {
            ((ContentFragment)fragments.get(i)).changeTextSize();
        }
    }
}
