package com.wk.spring.controller;

import com.alibaba.fastjson.JSON;
import com.wk.spring.entity.ProvinceEntity;
import com.wk.spring.entity.UserEntity;
import com.wk.spring.service.ProvinceService;
import com.wk.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ProvinceService provinceService;
    @ResponseBody
    @RequestMapping("/info")
    public String indexinfo(){
        ProvinceEntity entity = provinceService.getEntityById(1l);
        if (entity != null){
            return JSON.toJSONString(entity);
        }
        return "empty entity!";
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
