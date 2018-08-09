package com.wx.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TwoMenuMapper {
    List<Map<String, String>> getTwoMenuByOneId(@Param("id") Integer id);
}
