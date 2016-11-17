package com.jia.shigeten.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jia.shigeten.R;
import com.jia.shigeten.entry.Content;
import com.jia.shigeten.entry.ViewHolder;
import com.jia.shigeten.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器
 * Created by JIA on 2016/11/16.
 */

public class MyAdapter extends PagerAdapter{

    private Context context;                //上下文
    private LayoutInflater inflater;        //布局加载器
    private List<Content> contents;         //内容集合
    private int type;                       //内容类型

    private List<ViewHolder> holders = new ArrayList<>();         //控件集合

    public MyAdapter(Context context, int type, List<Content> contents){
        this.context = context;
        this.type = type;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.contents = contents;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = null;
        if (position == 0 || position == getCount()-1) {
            //第一页和最后一页设置为空白
            view = new View(context);
        }else{
            //开始获取详细信息，填充数据
            view = inflater.inflate(R.layout.item_list_content, container, false);
            final ViewHolder holder = new ViewHolder(view,contents.get(position-1).getId(),type);
            //重新加载holder
            if (holders.size() > position-1) holders.remove(position-1);
            holders.add(position-1,holder);
            new ContentMatch(context,holder).getContent();
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    /**
     * 设置空间字体大小(全部重置)
     */
    public void setTextSize(){
        for (int i = 0; i < holders.size(); i++) {
            holders.get(i).setTextSize(context);
        }
    }

    @Override
    public int getCount() {
        if (contents.size() == 0) return 1;
        return contents.size() + 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
