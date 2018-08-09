package com.wx.bean;

import java.util.List;

/**
 *
 * @类名: FatherButton
 * @描述: 一级菜单栏
 * @作者: 六
 * @时间: 2018年3月12日 上午10:05:41
 */
public class FatherButton extends Button{
    private List<?> sub_button;//通过数组来包含子菜单栏

    public List<?> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<?> sub_button) {
        this.sub_button = sub_button;
    }

}

