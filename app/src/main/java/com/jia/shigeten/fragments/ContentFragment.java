package com.jia.shigeten.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jia.shigeten.R;
import com.jia.shigeten.adapter.MyAdapter;
import com.jia.shigeten.entry.Content;
import com.jia.shigeten.entry.Result;
import com.jia.shigeten.utils.URLUtils;
import com.jia.shigeten.utils.Utils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 内容碎片模板
 * Created by JIA on 2016/11/16.
 */

public class ContentFragment extends Fragment {

    private View view;                                      //布局根控件

    private ImageView iv_loading;                           //加载
    private ImageView iv_retry;                             //重试

    private ViewPager vp;                                   //内容容器
    private List<Content> lists = new ArrayList<>();         //内容集合

    private int fragment_type;                              //碎片类型
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.item_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    /**
     * 初始化数据
     */
    private void init() {
        initView();
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        fragment_type = getArguments().getInt("fragment_type");
        vp.setOnPageChangeListener(new MyOnPageChangeListener());
        getData();
        iv_retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(View.INVISIBLE);
                Utils.startLoading(iv_loading);
                getData();
            }
        });
    }

    /**
     * 页面滑动时的监听
     */
    private class MyOnPageChangeListener extends ViewPager.SimpleOnPageChangeListener{
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            if (position == 0){
                vp.setCurrentItem(1);
                Toast.makeText(getActivity(), getResources().getString(R.string.already_first), Toast.LENGTH_SHORT).show();
            }else if (position == lists.size()+1){
                vp.setCurrentItem(lists.size());
                Toast.makeText(getActivity(), getResources().getString(R.string.already_last), Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 获取数据
     */
    private void getData() {
        Utils.startLoading(iv_loading);
        OkHttpUtils.get()
                .url(URLUtils.getUrl(fragment_type,true))
                .build()
                .execute(new MyGetDataCallBack());
    }

    /**
     * 获取到数据之后的回调
     */
    private class MyGetDataCallBack extends Callback<Result> {
        @Override
        public Result parseNetworkResponse(Response response, int id) throws Exception {
            return new Gson().fromJson(response.body().string(), Result.class);
        }

        @Override
        public void onError(Call call, Exception e, int id) {
            Utils.stopLoading(iv_loading);
            iv_retry.setVisibility(View.VISIBLE);
            Toast.makeText(getActivity(), "获取数据失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResponse(Result response, int id) {
            lists.addAll(response.getResult());
            adapter = new MyAdapter(getActivity(), fragment_type, lists);
            vp.setAdapter(adapter);
            vp.setCurrentItem(1);
            Utils.stopLoading(iv_loading);
        }
    }

    /**
     * 改变字体大小
     */
    public void changeTextSize(){
        if (null != adapter){
            adapter.setTextSize();
        }
    }

    /**
     * 初始化控件
     */
    private void initView() {
        iv_loading = (ImageView) view.findViewById(R.id.iv_loading);
        iv_retry = (ImageView) view.findViewById(R.id.iv_retry);
        vp = (ViewPager) view.findViewById(R.id.vp);
    }
}
