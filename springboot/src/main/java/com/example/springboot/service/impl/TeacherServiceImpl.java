package com.example.springboot.service.impl;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.controller.dto.UserDTO;
import com.example.springboot.entity.Teacher;
import com.example.springboot.mapper.TeacherMapper;
import com.example.springboot.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhc
 * @since 2023-04-15
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    private static final Log LOG= Log.get();
    @Override
    public boolean login(UserDTO userDTO) {
        QueryWrapper<Teacher> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("tusername",userDTO.getUsername());
        queryWrapper.eq("tpassword",userDTO.getPassword());
        try{
            Teacher one = getOne(queryWrapper);
            return one!=null;
        }catch (Exception e){
            LOG.error(e);
            return false;
        }
    }
}
