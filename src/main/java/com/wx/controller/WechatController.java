package com.wx.controller;


import com.wx.util.SignUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;

@RequestMapping("/wechat")
@Controller
public class WechatController {

    private static Logger logger = Logger.getLogger(WechatController.class);

    private static String WECHAT_TOKEN = "jinsanpang";

    @RequestMapping(value = "/wx.do")
    public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {

        logger.error("WechatController   ----   WechatController");

        System.out.println("========WechatController========= ");
        logger.info("请求进来了...");

        Enumeration pNames = request.getParameterNames();
        while (pNames.hasMoreElements()) {
            String name = (String) pNames.nextElement();
            String value = request.getParameter(name);
            // out.print(name + "=" + value);

            String log = "name =" + name + "     value =" + value;
            logger.error(log);
        }

        String signature = request.getParameter("signature");/// 微信加密签名
        String timestamp = request.getParameter("timestamp");/// 时间戳
        String nonce = request.getParameter("nonce"); /// 随机数
        String echostr = request.getParameter("echostr"); // 随机字符串
        PrintWriter out = response.getWriter();

        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        out.close();
        out = null;
    }

}