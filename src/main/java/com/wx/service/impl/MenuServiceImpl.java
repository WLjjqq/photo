package com.wx.service.impl;

import com.wx.bean.FatherButton;
import com.wx.bean.OneMenu;
import com.wx.mapper.OneMenuMapper;
import com.wx.mapper.TwoMenuMapper;
import com.wx.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    OneMenuMapper oneMenuMapper;

    @Autowired
    TwoMenuMapper twoMenuMapper;

    /**
     *
     * @标题: getMenu
     * @描述: 获取菜单栏样式
     * @return
     * @返回值: WeChatMenu
     */
    public List<FatherButton> getMenu(){
        //获取数据
        List<OneMenu> list = getAllOneMenu();
        List<FatherButton> menu = new ArrayList<FatherButton>();
        for (OneMenu oneMenu : list) {
            //创建一级按钮
            FatherButton fb = new FatherButton();
            //存入一级按钮名称
            fb.setName(oneMenu.getName());
            //存入二级按钮样式
            fb.setSub_button(getTwoMenuByOneId(oneMenu.getId()));
            menu.add(fb);
        }
        return menu;
    }

    /**
     *
     * @标题: getAllOneMenu
     * @描述: 获取所有父类菜单
     * @return
     */
    @Override
    public List<OneMenu> getAllOneMenu() {
        return oneMenuMapper.getAllOneMenu();
    }

    /**
     *
     * @标题: getTwoMenuByOneId
     * @描述: 根据父类id获取子类菜单
     * @param id
     * @return
     */
    public List<Map<String, String>> getTwoMenuByOneId(int id) {
        return twoMenuMapper.getTwoMenuByOneId(id);
    }

}
