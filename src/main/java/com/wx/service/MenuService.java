package com.wx.service;

import com.wx.bean.FatherButton;
import com.wx.bean.OneMenu;

import java.util.List;

public interface MenuService {
    List<FatherButton> getMenu();
    List<OneMenu> getAllOneMenu();
}
