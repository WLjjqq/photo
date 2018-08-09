package com.wx.dto;

/**
 *
 * @类名: WechatResultState
 * @描述: 微信返回值状态
 * @作者: 六
 * @时间: 2018年3月8日 上午10:27:25
 */
public class WechatResultState {
    private int errcode; // 状态

    private String errmsg; //信息

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

}

