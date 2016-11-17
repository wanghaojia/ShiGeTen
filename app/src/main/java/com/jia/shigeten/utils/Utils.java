package com.jia.shigeten.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jia.shigeten.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 小工具
 * Created by JIA on 2016/11/15.
 */

public class Utils {

    //页面标记
    public final static int CRITIC_TYPE = 0;
    public final static int NOVEL_TYPE = 1;
    public final static int DIAGRAM_TYPE = 2;

    //字体大小标记
    public final static int FONT_SMALL = 0;
    public final static int FONT_MIDDLE = 1;
    public final static int FONT_LARGE = 2;

    //字体类型标记
    public final static int FONT_CONTENT_TYPE = 0;
    public final static int FONT_TITLE_TYPE = 1;
    public final static int FONT_SIGN_TYPE = 2;

    /**
     * 格式化时间
     * @param t     时间字符串
     * @return      格式化之后的时间字符串
     */
    public static String getTime(String t){
        long time = Long.parseLong(t.substring(3,t.length()-4))+14643744l*100000l;
        Date date = new Date(time);
        return new SimpleDateFormat("yyyy.MM.dd").format(date);
    }

    /**
     * 开启加载动画
     * @param iv
     */
    public static void startLoading(ImageView iv){
        iv.setVisibility(View.VISIBLE);
        AnimationDrawable anim = (AnimationDrawable) iv.getDrawable();
        anim.start();
    }

    /**
     * 开启加载动画
     * @param iv
     */
    public static void stopLoading(ImageView iv){
        iv.setVisibility(View.INVISIBLE);
        AnimationDrawable anim = (AnimationDrawable) iv.getDrawable();
        anim.stop();
    }

    /**
     * 判断一个字符串是否有值
     * @return
     */
    public static boolean hasValue(String s){
        if (null == s || "".equals(s)) return false;
        else return true;
    }

    /**
     * 设置指定TextView 字体大小
     * @param context
     * @param tv
     */
    public static void setTextSize(Context context,int type,TextView tv){
        SharedPreferences font = context.getSharedPreferences("font", Context.MODE_PRIVATE);
        int fontsize = font.getInt("fontsize", 1);          //默认字体大小为中号
        if (type == 0){
            if (fontsize == 0) tv.setTextAppearance(context,R.style.Font20);
            else if (fontsize == 1) tv.setTextAppearance(context,R.style.Font32);
            else if (fontsize == 2) tv.setTextAppearance(context,R.style.Font42);
        }else if (type == 1){
            if (fontsize == 0) tv.setTextAppearance(context,R.style.Font24);
            else if (fontsize == 1) tv.setTextAppearance(context,R.style.Font36);
            else if (fontsize == 2) tv.setTextAppearance(context,R.style.Font48);
        }else if (type == 2){
            if (fontsize == 0) tv.setTextAppearance(context,R.style.Font18);
            else if (fontsize == 1) tv.setTextAppearance(context,R.style.Font28);
            else if (fontsize == 2) tv.setTextAppearance(context,R.style.Font36);
        }
    }
}
