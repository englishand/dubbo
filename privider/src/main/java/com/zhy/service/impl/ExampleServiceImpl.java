package com.zhy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhy.entity.User;
import com.zhy.service.ExampleService;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Override
    public String getName() {
        return "zhy";
    }

    @Override
    public User getUser() {
        return new User();
    }
}
