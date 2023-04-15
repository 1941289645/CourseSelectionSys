package com.example.springboot.service;

import com.example.springboot.controller.dto.UserDTO;
import com.example.springboot.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhc
 * @since 2023-04-15
 */
public interface ITeacherService extends IService<Teacher> {

    boolean login(UserDTO userDTO);
}
