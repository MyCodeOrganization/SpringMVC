package com.wk.spring.controller;

import com.alibaba.fastjson.JSON;
import com.wk.spring.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * PackageName com.wk.spring.controller
 * Created by wangkang on 2018/1/9.
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @ResponseBody
    @RequestMapping("/info")
    public String indexinfo(){
        return "index";
    }
    @ResponseBody
    @RequestMapping("/hello")
    public String indexlist(){
        System.out.println("into hello method!");
        return "hello world!";
    }
    @ResponseBody
    @RequestMapping("/userinfo")
    public String userinfo(){
        UserEntity user = new UserEntity();
        user.setId(123456l);
        user.setAge(18);
        user.setName("wangkang");
        user.setSex(1);
        return JSON.toJSONString(user);
    }
    @ResponseBody
    @RequestMapping("/indexview")
    public ModelAndView indexview(){
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }
    @ResponseBody
    @RequestMapping("/helloview")
    public String indexhelloview(){
        return "redirect:/pages/index.html";
    }

}
