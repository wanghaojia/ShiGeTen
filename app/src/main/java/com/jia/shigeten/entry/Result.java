package com.jia.shigeten.entry;

import java.util.List;

/**
 * 文章实体类
 * Created by JIA on 2016/11/15.
 */

public class Result {

    private List<Content> result;
    private int status;
    private String errMsg;

    public Result() {
    }

    public Result(List<Content> result, int status, String errMsg) {
        this.result = result;
        this.status = status;
        this.errMsg = errMsg;
    }

    public List<Content> getResult() {
        return result;
    }

    public void setResult(List<Content> result) {
        this.result = result;
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

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result.toString() +
                ", status=" + status +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
