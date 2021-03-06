package com.cym.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.cym.demo.model.User;
import com.cym.demo.model.User1;
import com.cym.demo.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/3.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private UserServiceI userService;

    public UserServiceI getUserService()
    {
        return userService;
    }

    @Autowired
    public void setUserService(UserServiceI userService)
    {
        this.userService = userService;
    }
    /**
     * ajax 请求（springMVC会自动转成json无需再使用JSON.toJSONString转换）
     *
     * @param
     * @return List<Map<String,Object>> to json串
     *
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody
    JSONObject getUserMap(HttpServletRequest request, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
//        List<Map<String, Object>> u = userService.getMaplist();
        User1 user1 =userService.getUserById1(1);
        JSONObject obj = new JSONObject();
        obj.put("data",user1);
        return obj;
    }


}
