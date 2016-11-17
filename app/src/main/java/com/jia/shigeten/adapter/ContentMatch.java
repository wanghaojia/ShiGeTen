package com.jia.shigeten.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jia.shigeten.R;
import com.jia.shigeten.entry.Content;
import com.jia.shigeten.entry.ViewHolder;
import com.jia.shigeten.utils.URLUtils;
import com.jia.shigeten.utils.Utils;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 填充内容的适配器
 * Created by JIA on 2016/11/16.
 */

public class ContentMatch implements View.OnClickListener{

    private Context context;                //上下文
    private ViewHolder holder;              //要赋值的控件集合对象
    private int type;                       //页面类型
    private int id;                         //内容id

    public ContentMatch(Context context,ViewHolder holder) {
        this.holder = holder;
        this.type = holder.getType();
        this.id = holder.getId();
        this.context = context;
        setListener();
    }

    /**
     * 设置监听
     */
    private void setListener() {
        holder.getIv_favorite().setOnClickListener(this);
        holder.getIv_retry().setOnClickListener(this);
    }

    /**
     * 获取内容数据
     */
    public void getContent() {
        Utils.startLoading(holder.getIv_loading());
        OkHttpUtils.get()
                .url(URLUtils.getUrl(type,false))
                .addParams("id",""+id)
                .build()
                .execute(new MyGetContentCallBack());
    }

    /**
     * 控件点击事件的处理
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){case R.id.iv_favorite:
                changeFavorite();
                break;
            case R.id.iv_retry:
                retry();
                break;
        }
    }

    /**
     * 重新获取数据
     */
    public void retry(){
        holder.getIv_loading().setVisibility(View.VISIBLE);
        holder.getIv_retry().setVisibility(View.GONE);
        getContent();
    }

    /**
     * 改变收藏状态
     */
    private void changeFavorite() {
        SharedPreferences favorite = context.getSharedPreferences("favorite", Context.MODE_PRIVATE);
        int favoriteType = favorite.getInt(holder.getId() + "", -1);
        SharedPreferences.Editor edit = favorite.edit();
        if (favoriteType != -1){
            holder.getIv_favorite().setImageResource(R.drawable.favorite);
            edit.remove(holder.getId()+"");
            edit.apply();
        }else{
            holder.getIv_favorite().setImageResource(R.drawable.favorite_selected);
            edit.putInt(holder.getId()+"",type);
            edit.apply();
        }
    }

    /**
     * 获取收藏状态
     * @return
     */
    public boolean getFavoriteState(){
        SharedPreferences favorite = context.getSharedPreferences("favorite", Context.MODE_PRIVATE);
        int favoriteType = favorite.getInt(holder.getId() + "", -1);
        return favoriteType != -1;
    }

    /**
     * 获取到内容之后的回调
     */
    public class MyGetContentCallBack extends Callback<Content> {

        @Override
        public Content parseNetworkResponse(Response response, int id) throws Exception {
            return new Gson().fromJson(response.body().string(),Content.class);
        }

        @Override
        public void onError(Call call, Exception e, int id) {
            Utils.stopLoading(holder.getIv_loading());
            holder.getIv_retry().setVisibility(View.VISIBLE);
            Toast.makeText(context, "获取数据失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResponse(Content response, int id) {
            Log.e("------","成功获取内容");
            Utils.stopLoading(holder.getIv_loading());
            //重置字体大小
            holder.setTextSize(context);
            //设置收藏状态
            holder.getIv_favorite().setImageResource(getFavoriteState() ? R.drawable.favorite_selected : R.drawable.favorite);
            //设置发表时间
            holder.getTv_time().setText(Utils.getTime(response.getPublishtime()+""));
            //设置标题，作者，阅读量
            holder.getTv_title().setText(response.getTitle());
            holder.getTv_author_times().setText(String.format(context.getResources().getString(R.string.author_times),response.getAuthor(),response.getTimes()+""));
            if (type != Utils.NOVEL_TYPE){
                holder.getLl_summary().setVisibility(View.GONE);
                //设置海报,美图页面使用image1
                Picasso.with(context).load(URLUtils.BASE_URL+(type == Utils.CRITIC_TYPE ? response.getImageforplay() : response.getImage1())).into(holder.getIv_image_forplay());
            } else {
                holder.getIv_image_forplay().setVisibility(View.GONE);
                //设置summary，小说页面可见
                holder.getTv_summary().setText(response.getSummary());
                holder.getTv_text().setText(response.getText());
            }
            //设置图片集合
            for (int i = 0; i < 5; i++) {
                if (type != Utils.DIAGRAM_TYPE){            //美图的image1不放在这里，放在海报的位置
                    if (response.getImgs().size() > i && Utils.hasValue(response.getImgs().get(i))){
                        Picasso.with(context).load(URLUtils.BASE_URL+response.getImgs().get(i)).into(holder.getIv_images().get(i));
                        continue;
                    }
                }
                holder.getIv_images().get(i).setVisibility(View.GONE);
            }
            //设置文字集合
            for (int i = 0; i < 5; i++) {
                if (response.getTexts().size() >i && Utils.hasValue(response.getTexts().get(i))){
                    holder.getTv_texts().get(i).setText(response.getTexts().get(i));
                    continue;
                }
                holder.getTv_texts().get(i).setVisibility(View.GONE);
            }
            if (type == Utils.DIAGRAM_TYPE){                //如果是美图，则将image1设置在海报的位置
                Picasso.with(context).load(URLUtils.BASE_URL+response.getImage1()).into(holder.getIv_image_forplay());
                holder.getTv_texts().get(1).setGravity(Gravity.RIGHT);
            }
            holder.getTv_author().setText(response.getAuthor());
            holder.getTv_author_brief().setText(response.getAuthorbrief());
        }
    }
}
