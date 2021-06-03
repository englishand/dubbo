package com.zhy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhy.entity.User;
import com.zhy.service.ExampleService;

@Service
public class ExampleServiceImpl implements ExampleService {

    private int i;
    private int j;
    @Override
    public String getName() {
        i++;
        System.out.println(i+"  测试使用多个dubbo服务20880、20881;方法：getName;这是20880端口下dubbo服务启动的privider");
        return "zhy";
    }

    @Override
    public User getUser() {
        j++;
        System.out.println(j+"  测试使用多个dubbo服务20880、20881;方法：getUser;这时20880端口下dubbo服务启动的privider");
        return new User();
    }
}
