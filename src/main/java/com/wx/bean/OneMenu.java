package com.wx.bean;

/**
 *
 * @类名: OneMenu
 * @描述: 父菜单栏
 * @作者: 六
 * @时间: 2018年3月13日 上午9:15:58
 */
public class OneMenu {
    private int menuId;
    private String menuname;

    public int getId() {
        return menuId;
    }
    public void setId(int menuId) {
        this.menuId = menuId;
    }
    public String getName() {
        return menuname;
    }
    public void setName(String menuname) {
        this.menuname = menuname;
    }

    @Override
    public String toString() {
        return "OneMenu{" +
                "menuId=" + menuId +
                ", menuname='" + menuname + '\'' +
                '}';
    }
}

