package com.wx.service.impl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wx.bean.WeChatMenu;
import com.wx.service.WeChatMenuService;
import com.wx.util.HttpClientUtil;
import com.wx.util.JsonUtils;
import org.springframework.stereotype.Service;
@Service
public class WeChatMenuServiceImpl implements WeChatMenuService {

    public static String menuUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    public static String removeMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    @Override
    public JSONObject creatMenu(String token) {
        JSONObject result = null;
        // 拼接token
        String url = menuUrl.replace("ACCESS_TOKEN", token);

        // 获取菜单样式并转换成json格式
        String jsonMenu = JsonUtils.getObjectToJson(getMenu());
        // 提交数据到微信端
        try {
            String jsonObject = HttpClientUtil.doPostJson(url, jsonMenu);
            result = JSON.parseObject(jsonObject);
        } catch (Exception e) {
            System.out.println("请求错误：" + e.getMessage());
        }
        return result;
    }

    @Override
    public JSONObject removeMenu(String token) {
        JSONObject result = null;
        // 拼接token
        String url = removeMenuUrl.replace("ACCESS_TOKEN", token);
        // 移除菜单栏
        try {
            String jsonObject = HttpClientUtil.doGet(url);
            result = JSON.parseObject(jsonObject);
        } catch (Exception e) {
            System.out.println("请求错误：" + e.getMessage());
        }
        return result;
    }

   /* @Value("${REST_URL}")
    String REST_URL;

    @Value("${REST_GETMENU}")
    String REST_GETMENU;*/

    /**
     *
     * @标题: getMenu
     * @描述: 获取微信菜单
     * @return
     */
    @Override
    public WeChatMenu getMenu() {
        //后台连接
        String url = "http://localhost:8080/wexinmenu/getMenu";
        //获取数据
        String json = HttpClientUtil.doGet(url);
       // JSONObject jsonPojo = JSON.parseObject(json);
        WeChatMenu menu = JsonUtils.getStringToObject(json, WeChatMenu.class);
        return menu;
    }

}

