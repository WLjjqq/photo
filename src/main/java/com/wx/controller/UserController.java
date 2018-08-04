package com.wx.controller;


import com.wx.bean.User;
import com.wx.dto.Result;
import com.wx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userById",method = RequestMethod.GET)
    @ResponseBody
    public Result getUserById(@RequestParam("id") Integer id) {
        User user = userService.queryUserById(id);
        return new Result(true, user, "success");
    }

    @RequestMapping(value = "test1",method = RequestMethod.GET)
    public String test1(){
        return "test1";
    }
}
