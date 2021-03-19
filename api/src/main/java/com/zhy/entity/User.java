package com.zhy.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String uuid;
    private String username;
    private String password;
    private String msg;
}
