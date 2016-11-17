package com.jia.shigeten.entry;

import android.util.Log;

import com.jia.shigeten.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容实体类
 * Created by JIA on 2016/11/15.
 */

public class Content {

    private int id;
    private int type;
    private long publishtime;
    private String title;
    private String summary;
    private String image;

    private String author;
    private String authorbrief;
    private int times;
    private String text;
    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String text5;

    private List<String> texts;

    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;

    private List<String> imgs;

    private String imageforplay;
    private String urlforplay;
    private String titleforplay;
    private String realtitle;
    private int status;
    private String errMsg;

    public Content() {
    }

    public Content(int id, int type, int publishtime, String title, String summary, String image) {
        this.id = id;
        this.type = type;
        this.publishtime = publishtime;
        this.title = title;
        this.summary = summary;
        this.image = image;
    }

    public Content(int id, long publishtime, String title, String author, String authorbrief, int times, String text1, String text2, String image5, String image4, String image3, String image2, String image1, String text5, String text4, String text3, String imageforplay, String urlforplay, String titleforplay, String realtitle, int status, String errMsg) {
        this.id = id;
        this.publishtime = publishtime;
        this.title = title;
        this.author = author;
        this.authorbrief = authorbrief;
        this.times = times;
        this.text1 = text1;
        this.text2 = text2;
        this.image5 = image5;
        this.image4 = image4;
        this.image3 = image3;
        this.image2 = image2;
        this.image1 = image1;
        this.text5 = text5;
        this.text4 = text4;
        this.text3 = text3;
        this.imageforplay = imageforplay;
        this.urlforplay = urlforplay;
        this.titleforplay = titleforplay;
        this.realtitle = realtitle;
        this.status = status;
        this.errMsg = errMsg;
    }

    public Content(String text, String authorbrief, String author, String summary, int id, long publishtime, String title, String errMsg, int times, int status, String image) {
        this.text = text;
        this.authorbrief = authorbrief;
        this.author = author;
        this.summary = summary;
        this.id = id;
        this.publishtime = publishtime;
        this.title = title;
        this.errMsg = errMsg;
        this.times = times;
        this.status = status;
        this.image = image;
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

    public long getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(long publishtime) {
        this.publishtime = publishtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorbrief() {
        return authorbrief;
    }

    public void setAuthorbrief(String authorbrief) {
        this.authorbrief = authorbrief;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public String getImageforplay() {
        return imageforplay;
    }

    public void setImageforplay(String imageforplay) {
        this.imageforplay = imageforplay;
    }

    public String getUrlforplay() {
        return urlforplay;
    }

    public void setUrlforplay(String urlforplay) {
        this.urlforplay = urlforplay;
    }

    public String getTitleforplay() {
        return titleforplay;
    }

    public void setTitleforplay(String titleforplay) {
        this.titleforplay = titleforplay;
    }

    public String getRealtitle() {
        return realtitle;
    }

    public void setRealtitle(String realtitle) {
        this.realtitle = realtitle;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getText() {
        return text;

    }

    public List<String> getTexts() {
        if (texts == null) {
            texts = new ArrayList<>();
            if (Utils.hasValue(text1)) texts.add(text1);
            if (Utils.hasValue(text2)) texts.add(text2);
            if (Utils.hasValue(text3)) texts.add(text3);
            if (Utils.hasValue(text4)) texts.add(text4);
            if (Utils.hasValue(text5)) texts.add(text5);
        }
        return texts;
    }

    public List<String> getImgs() {
        if (imgs == null){
            imgs = new ArrayList<>();
            if (image1 != null && !image1.equals("")) imgs.add(image1);
            if (image2 != null && !image2.equals("")) imgs.add(image2);
            if (image3 != null && !image3.equals("")) imgs.add(image3);
            if (image4 != null && !image4.equals("")) imgs.add(image4);
            if (image5 != null && !image5.equals("")) imgs.add(image5);
        }
        return imgs;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", type=" + type +
                ", publishtime=" + publishtime +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", image='" + image + '\'' +
                ", author='" + author + '\'' +
                ", authorbrief='" + authorbrief + '\'' +
                ", times=" + times +
                ", text='" + text + '\'' +
                ", text1='" + text1 + '\'' +
                ", text2='" + text2 + '\'' +
                ", text3='" + text3 + '\'' +
                ", text4='" + text4 + '\'' +
                ", text5='" + text5 + '\'' +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", image3='" + image3 + '\'' +
                ", image4='" + image4 + '\'' +
                ", image5='" + image5 + '\'' +
                ", imageforplay='" + imageforplay + '\'' +
                ", urlforplay='" + urlforplay + '\'' +
                ", titleforplay='" + titleforplay + '\'' +
                ", realtitle='" + realtitle + '\'' +
                ", status=" + status +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
