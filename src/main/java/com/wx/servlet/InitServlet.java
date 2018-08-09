package com.wx.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.wx.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 类名: InitServlet </br>
 * 描述: 初始化servlet </br>
 * 开发人员： souvc </br>
 * 创建时间：  Oct 6, 2015 </br>
 * 发布版本：V1.0  </br>
 */

@WebServlet(
        name = "AccessTokenServlet",
        urlPatterns = {"/AccessTokenServlet"},
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "appId", value = "wxb05f6ccd16cf38fb"),
                @WebInitParam(name = "appSecret", value = "b50d2e0911e255f4723f93d73233b04f")
        })
public class InitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(CommonUtil.class);

    public void init() throws ServletException {
        System.out.println("启动得到Token的Servlet");
        // 获取web.xml中配置的参数
        TokenThread.appid = getInitParameter("appId");
        TokenThread.appsecret = getInitParameter("appSecret");

        log.info("weixin api appid:{}", TokenThread.appid);
        log.info("weixin api appsecret:{}", TokenThread.appsecret);

        // 未配置appid、appsecret时给出提示
        if ("".equals(TokenThread.appid) || "".equals(TokenThread.appsecret)) {
            log.error("appid and appsecret configuration error, please check carefully.");
        } else {
            // 启动定时获取access_token的线程
            new Thread(new TokenThread()).start();
        }
    }
}