package com.szymon.controller;

import com.szymon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("hello")
    public Map<String, Object> hello() {
        Map<String, Object> map = helloService.getData();
        map.put("users", helloService.getAllUsers());
        return map;
    }
}
