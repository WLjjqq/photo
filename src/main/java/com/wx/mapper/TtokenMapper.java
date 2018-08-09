package com.wx.mapper;

import com.wx.bean.AccessToken;
import com.wx.bean.Ttoken;

public interface TtokenMapper {
    //读取token。
    Ttoken select();
    //保存token。
    int save(Ttoken ttoken);
}
