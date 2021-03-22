package com.zhy.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * dubbo服务间的应用即跨服务器之间的服务调用
 * 调用过程中通过数据网络传输模拟信号。（网卡称数模转换器，转换两者需要的信号）
 * Java中，只要实体类序列化，jvm会把pojo转换成对应的信号进行传输。
 */

@Data
public class User implements Serializable {

    private String uuid;
    private String username;
    private String password;
    private String msg;
}
