package com.wx.bean;

import java.util.List;

/**
 *
 * @类名: WeChatMenu
 * @描述: 微信菜单实体类
 * @作者: 六
 * @时间: 2018年3月12日 上午10:10:21
 */
public class WeChatMenu {

    private List<?> button;//对整个菜单进行合并实体合并

    public List<?> getButton() {
        return button;
    }

    public void setButton(List<?> button) {
        this.button = button;
    }

}

