package com.zhy.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zhy.entity.User;
import com.zhy.service.ExampleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ExampleController {

    @Reference
    private ExampleService exampleService;

    @RequestMapping("/name")
    public String getName(){
        return exampleService.getName();
    }

    @RequestMapping("getUser")
    public User getUser(){
        return exampleService.getUser();
    }
}
