package com.jia.shigeten.entry;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jia.shigeten.R;
import com.jia.shigeten.adapter.MyAdapter;
import com.jia.shigeten.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JIA on 2016/11/16.
 */

public class ViewHolder {

    private TextView tv_time;                   //时间
    private ImageView iv_favorite;              //收藏
    private ImageView iv_image_forplay;         //封面
    private TextView tv_title;                  //标题
    private TextView tv_author_times;           //作者及阅读量
    private LinearLayout ll_summary;            //。。
    private TextView tv_summary;            //。。文本
    private  TextView tv_text;                   //文本
    private List<TextView> tv_texts = new ArrayList<>();              //内容文字
    private  List<ImageView> iv_images = new ArrayList<>();        //内容图片
    private  TextView tv_author;                 //作者
    private  TextView tv_author_brief;           //作者信息
    private  ImageView iv_loading;               //加载中
    private  ImageView iv_retry;                 //重新加载

    private int id;                     //内容id
    private int type;                   //内容类型

    public ViewHolder(View parent,int id,int type) {
        setAll(parent);
        this.id = id;
        this.type = type;
    }

    public TextView getTv_time() {
        return tv_time;
    }

    public void setTv_time(TextView tv_time) {
        this.tv_time = tv_time;
    }

    public ImageView getIv_favorite() {
        return iv_favorite;
    }

    public void setIv_favorite(ImageView iv_favorite) {
        this.iv_favorite = iv_favorite;
    }

    public ImageView getIv_image_forplay() {
        return iv_image_forplay;
    }

    public void setIv_image_forplay(ImageView iv_image_forplay) {
        this.iv_image_forplay = iv_image_forplay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public TextView getTv_title() {
        return tv_title;
    }

    public void setTv_title(TextView tv_title) {
        this.tv_title = tv_title;
    }

    public TextView getTv_author_times() {
        return tv_author_times;
    }

    public void setTv_author_times(TextView tv_author_times) {
        this.tv_author_times = tv_author_times;
    }

    public LinearLayout getLl_summary() {
        return ll_summary;
    }

    public void setLl_summary(LinearLayout ll_summary) {
        this.ll_summary = ll_summary;
    }

    public TextView getTv_summary() {
        return tv_summary;
    }

    public void setTv_summary(TextView tv_summary) {
        this.tv_summary = tv_summary;
    }

    public TextView getTv_text() {
        return tv_text;
    }

    public void setTv_text(TextView tv_text) {
        this.tv_text = tv_text;
    }

    public List<TextView> getTv_texts() {
        return tv_texts;
    }

    public void setTv_texts(List<TextView> tv_texts) {
        this.tv_texts = tv_texts;
    }

    public List<ImageView> getIv_images() {
        return iv_images;
    }

    public void setIv_images(List<ImageView> iv_images) {
        this.iv_images = iv_images;
    }

    public TextView getTv_author() {
        return tv_author;
    }

    public void setTv_author(TextView tv_author) {
        this.tv_author = tv_author;
    }

    public TextView getTv_author_brief() {
        return tv_author_brief;
    }

    public void setTv_author_brief(TextView tv_author_brief) {
        this.tv_author_brief = tv_author_brief;
    }

    public ImageView getIv_loading() {
        return iv_loading;
    }

    public void setIv_loading(ImageView iv_loading) {
        this.iv_loading = iv_loading;
    }

    public ImageView getIv_retry() {
        return iv_retry;
    }

    public void setIv_retry(ImageView iv_retry) {
        this.iv_retry = iv_retry;
    }

    /**
     * 通过一个view获取所有对象
     */
    private void setAll(View view){
        tv_time = (TextView) view.findViewById(R.id.tv_time);
        iv_favorite = (ImageView) view.findViewById(R.id.iv_favorite);
        iv_image_forplay = (ImageView) view.findViewById(R.id.iv_image_forplay);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_author_times = (TextView) view.findViewById(R.id.tv_author_times);
        ll_summary = (LinearLayout) view.findViewById(R.id.ll_summary);
        tv_summary = (TextView) view.findViewById(R.id.tv_summary);
        tv_text = (TextView) view.findViewById(R.id.tv_text);
        int[] textIds = {R.id.tv_text1,R.id.tv_text2,R.id.tv_text3,R.id.tv_text4,R.id.tv_text5};
        int[] imgIds = {R.id.iv_image1,R.id.iv_image2,R.id.iv_image3,R.id.iv_image4,R.id.iv_image5};
        for (int i = 0; i < 5; i++) {
            tv_texts.add((TextView) view.findViewById(textIds[i]));
            iv_images.add((ImageView) view.findViewById(imgIds[i]));
        }
        tv_author = (TextView) view.findViewById(R.id.tv_author);
        tv_author_brief = (TextView) view.findViewById(R.id.tv_author_brief);
        iv_loading = (ImageView) view.findViewById(R.id.iv_loading);
        iv_retry = (ImageView) view.findViewById(R.id.iv_retry);
    }

    /**
     * 设置控件字体大小(以)
     */
    public void setTextSize(Context context){
        Utils.setTextSize(context,Utils.FONT_SIGN_TYPE,tv_time);
        Utils.setTextSize(context,Utils.FONT_TITLE_TYPE,tv_title);
        Utils.setTextSize(context,Utils.FONT_SIGN_TYPE,tv_author_times);
        Utils.setTextSize(context,Utils.FONT_CONTENT_TYPE,tv_summary);
        Utils.setTextSize(context,Utils.FONT_CONTENT_TYPE,tv_text);
        for (int j = 0; j < 5; j++) {
            Utils.setTextSize(context,Utils.FONT_CONTENT_TYPE,tv_texts.get(j));
        }
        Utils.setTextSize(context,Utils.FONT_TITLE_TYPE,tv_author);
        Utils.setTextSize(context,Utils.FONT_SIGN_TYPE,tv_author_brief);
    }
}
