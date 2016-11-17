package com.jia.shigeten.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.jia.shigeten.AboutUsActivity;
import com.jia.shigeten.FavoriteActivity;
import com.jia.shigeten.FeedBackActivity;
import com.jia.shigeten.FontSettingActivity;
import com.jia.shigeten.MainActivity;
import com.jia.shigeten.R;

/**
 * 个人中心
 * Created by JIA on 2016/11/14.
 */

public class SettingFragment extends Fragment implements View.OnClickListener{

    private View view;                          //布局根控件

    private RelativeLayout rl_favorite;         //我的收藏
    private RelativeLayout rl_fontsetting;      //字体设置
    private RelativeLayout rl_aboutus;          //关于十个
    private RelativeLayout rl_feedback;         //意见反馈

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_setting, container, false);
        initView();
        return view;
    }

    /**
     * 初始化控件
     */
    private void initView() {
        rl_favorite = (RelativeLayout) view.findViewById(R.id.favorite);
        rl_fontsetting = (RelativeLayout) view.findViewById(R.id.fontsetting);
        rl_aboutus = (RelativeLayout) view.findViewById(R.id.aboutus);
        rl_feedback = (RelativeLayout) view.findViewById(R.id.feedback);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        setListener();
    }

    /**
     * 设置监听
     */
    private void setListener() {
        rl_favorite.setOnClickListener(this);
        rl_fontsetting.setOnClickListener(this);
        rl_aboutus.setOnClickListener(this);
        rl_feedback.setOnClickListener(this);
    }

    /**
     * 控件被点击之后的回调
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.favorite:                 //个人收藏
                startActivity(new Intent(getActivity(),FavoriteActivity.class));
                break;
            case R.id.fontsetting:             //字体设置
                getActivity().startActivityForResult(new Intent(getActivity(),FontSettingActivity.class),0);
                break;
            case R.id.aboutus:                  //关于十个
                startActivity(new Intent(getActivity(),AboutUsActivity.class));
                break;
            case R.id.feedback:                 //意见反馈
                startActivity(new Intent(getActivity(),FeedBackActivity.class));
                break;
        }
    }

}
