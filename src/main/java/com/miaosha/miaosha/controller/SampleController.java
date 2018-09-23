package com.miaosha.miaosha.controller;

import com.miaosha.miaosha.domain.User;
import com.miaosha.miaosha.redis.RedisConfig;
import com.miaosha.miaosha.redis.RedisService;
import com.miaosha.miaosha.redis.UserKey;
import com.miaosha.miaosha.vo.enums.CodeMsg;
import com.miaosha.miaosha.service.UserService;
import com.miaosha.miaosha.utils.ResultUtil;
import com.miaosha.miaosha.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by WangPeilei
 * Time 2018/9/22 11:01
 */
@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @Autowired
    RedisConfig redisConfig;


    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "Joshua");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result dbGet() {
        User user = userService.getById(1);
        return ResultUtil.success(CodeMsg.SUCCESS, user);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result redisGet() {
        User user = redisService.get(UserKey.getById, "" + 1, User.class);
        return ResultUtil.success(user);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result redisSet() {
        User user = new User();
        user.setId(1);
        user.setName("1111");
        redisService.set(UserKey.getById, "" + user.getId(), user); //UserKey:id1
        return ResultUtil.success(true);
    }


}
