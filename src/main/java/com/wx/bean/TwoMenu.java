package com.wx.bean;

/**
 *
 * @类名: TwoMenu
 * @描述: 子菜单栏
 * @作者: 六
 * @时间: 2018年3月13日 上午9:17:24
 */
public class TwoMenu {
    private int id;
    private String name;
    private String type;//二级菜单属性
    private String key;//二级菜单属性
    private String url;//二级菜单属性
    private int oneId;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getOneId() {
        return oneId;
    }
    public void setOneId(int oneId) {
        this.oneId = oneId;
    }
}
