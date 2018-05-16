package com.xinyonghang.supplychain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Map<String, Object> map) {
        map.put("msg", "你好，世界");
        return "hello";
    }

}
