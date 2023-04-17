package com.example.springboot.controller.dto;

import lombok.Data;

/**
 * 接收前端登录请求的参数
 */
@Data
public class UserDTO {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String avatarurl;
}
