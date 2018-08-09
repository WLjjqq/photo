package com.wx.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class JsonUtils {

    /**
     * 8.通过JSONArray.parseArray把json转换为List<T>
     *
     * @param jsonStr
     * @param model
     * @return
     */
    public static <T> List<T> getStringToList(String jsonStr, Class<T> model) {
        List<T> object = (List<T>) JSONArray.parseArray(jsonStr, model);
        return object;
    }

    public static <T> T getStringToObject(String jsonStr, Class<T> model){
        return JSONObject.parseObject(jsonStr, model);
    }

    public static <T> String getObjectToJson(T model)
    {
        String StrObject = JSONObject.toJSONString(model);
        return StrObject;
    }
}
