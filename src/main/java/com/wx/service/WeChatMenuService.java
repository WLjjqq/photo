package com.wx.service;

import com.alibaba.fastjson.JSONObject;
import com.wx.bean.WeChatMenu;
import com.wx.dto.WechatResultState;

public interface WeChatMenuService {
    JSONObject creatMenu(String token);
    JSONObject removeMenu(String token);
    //获取微信菜单。
    WeChatMenu getMenu();
}
