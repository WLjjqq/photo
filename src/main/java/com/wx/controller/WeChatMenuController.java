package com.wx.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.bean.WeChatMenu;
import com.wx.service.MenuService;
import com.wx.service.WeChatMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @类名: WeChatMenuController
 * @描述: TODO
 * @作者: 六
 * @时间: 2018年3月13日 上午11:32:47
 */
@Controller
@RequestMapping("/wexinmenu")
public class WeChatMenuController {
    @Autowired
    MenuService menuService;

    @Autowired
    WeChatMenuService weChatMenuService;


    @RequestMapping("/getMenu")
    @ResponseBody
    public WeChatMenu getMenu() {
        //整合整个菜单对象
        WeChatMenu menu = new WeChatMenu();
        menu.setButton(menuService.getMenu());
        return menu;
    }

    @RequestMapping(value = "/")
    @ResponseBody
    public JSONObject test() {
        JSONObject jinsanpang = weChatMenuService.creatMenu("jinsanpang");
        return jinsanpang;
    }


}

