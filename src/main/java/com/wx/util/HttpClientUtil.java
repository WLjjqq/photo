package com.wx.util;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @类名: HttpClientUtil
 * @描述: HttpClient工具类
 * @作者: 六
 * @时间: 2017年12月18日 上午11:38:44
 */
public class HttpClientUtil {
    private static Logger logger = Logger.getLogger(HttpClientUtil.class);
    private static CookieStore cookieStore= new BasicCookieStore();

    public static String getCookie(String name){

        List<Cookie> cookies =  cookieStore.getCookies();

        for(Cookie cookie : cookies){

            if(cookie.getName().equalsIgnoreCase(name)){

                return cookie.getValue();
            }
        }


        return null;

    }

    public static String doGet(String url, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();;
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(),
                        "UTF-8");
            }
        } catch (Exception e) {
            logger.error(e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                logger.error(e);
            }
        }
        return resultString;
    }

    public static String doGet(String url) {
        return doGet(url, null);
    }
    /**
     *
     * @标题: doPost
     * @描述: 接口用@RequestParam 单个,单个参数接收或者用javabean
     * @param url
     * @param param
     * @return
     * @返回值: String
     */
    public static String doPost(String url, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpclient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            logger.error(e);
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                logger.error(e);
            }
        }
        return resultString;
    }
    /**
     *
     * @标题: doPostbyFrom
     * @描述: 文件提交,接口用MultipartFile类,file为名接收
     * @param url
     * @param file
     * @return
     * @返回值: String
     */
    public static String doPostbyFrom(String url, MultipartFile file) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();;
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            String fileName = file.getOriginalFilename();
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            MultipartEntityBuilder meb = MultipartEntityBuilder.create();
            meb.addBinaryBody("file", file.getInputStream(),ContentType.MULTIPART_FORM_DATA, fileName);
            meb.addTextBody("filename", fileName);
            HttpEntity httpentity = meb.build();
            httpPost.setEntity(httpentity);

            // 执行http请求
            response = httpclient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } catch (Exception e) {
            logger.error(e);
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                logger.error(e);
            }
        }
        return resultString;
    }

    /**
     *
     * @标题: doPostJson
     * @描述: 接口用@requestByod 的javabean或者Map接收
     * @param url
     * @param json
     * @return
     * @返回值: String
     */
    public static String doPostJson(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json,
                    ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
		     // 执行http请求
             response = httpclient.execute(httpPost);
             resultString = EntityUtils.toString(response.getEntity(), "utf-8");

        } catch (Exception e) {
            logger.error(e);
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                logger.error(e);
            }
        }
        return resultString;
    }

    public static String doPost(String url) {
        return doPost(url, null);
    }


    public static String doPostJsonByCookie(String url, String json,List<String> cookies) {

        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json,
                    ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpclient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            if (response!=null && !response.equals("")) {

                Header[] headers = response.getHeaders("Set-Cookie");

                for (int i = 0; i < headers.length; i++) {


                    cookies.add(headers[i].getValue());

                }



            }

        } catch (Exception e) {
            logger.error(e);
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                logger.error(e);
            }
        }
        return resultString;


    }


}

