package com.wx.servlet;


import com.wx.bean.AccessToken;
import com.wx.bean.Ttoken;
import com.wx.mapper.TtokenMapper;
import com.wx.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 类名: TokenThread </br>
 * 描述: 定时获取微信access_token的线程 </br>
 * 开发人员： souvc </br>
 * 创建时间：  Oct 6, 2015 </br>
 * 发布版本：V1.0  </br>
 */
public class TokenThread implements Runnable {
    private static Logger log = LoggerFactory.getLogger(TokenThread.class);

   /* @Autowired
    TtokenMapper ttokenMapper;
*/
    // 第三方用户唯一凭证
    public static String appid = "";
    // 第三方用户唯一凭证密钥
    public static String appsecret = "";
    public static AccessToken accessToken = null;

    public void run() {
        while (true) {
            try {
                accessToken = CommonUtil.getToken(appid, appsecret);
                if (null != accessToken) {
                    //调用存储到数据库
                    System.out.println("Token的值："+accessToken);
                    Ttoken ttoken = new Ttoken(3,accessToken.getAccessToken(),accessToken.getExpiresin(),null);
                    System.out.println("Ttoken的值："+ttoken);
                    //ttokenMapper.select();
                    //ttokenMapper.save(ttoken);
                    log.info("获取access_token成功，有效时长{}秒 token:{}", accessToken.getExpiresin(), accessToken.getAccessToken());
                    // 休眠7000秒
                    Thread.sleep((accessToken.getExpiresin() - 200)*1000);
                } else {
                    // 如果access_token为null，60秒后再获取
                    Thread.sleep(60 * 1000);
                }
            } catch (InterruptedException e) {
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e1) {
                    log.error("{}", e1);
                }
                log.error("{}", e);
            }
        }
    }
}
