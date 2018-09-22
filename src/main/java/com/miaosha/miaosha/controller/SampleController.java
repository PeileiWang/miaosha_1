package com.miaosha.miaosha.controller;

import com.miaosha.miaosha.enums.CodeMsg;
import com.miaosha.miaosha.utils.ResultUtil;
import com.miaosha.miaosha.vo.Result;
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
    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "Joshua");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result dbGet() {
        return ResultUtil.success(CodeMsg.SUCCESS, "Hi");
    }
}
