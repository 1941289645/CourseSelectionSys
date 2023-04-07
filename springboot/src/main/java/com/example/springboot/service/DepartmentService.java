package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.Department;
import com.example.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends ServiceImpl<DepartmentMapper,Department> {
    public boolean saveDepartment(Department department) {
//       if(department.getDeptid()==null){
//           return save(department);  //mybatis-plus提供的方法，表示插入数据
//       }else {
//           return updateById(department);
//       }
        return saveOrUpdate(department);
    }

//    @Autowired
//    private DepartmentMapper departmentMapper;

//    public int save(Department department){
//        if(department.getDeptid()==null){  //user没有id，则表示新增
//            return departmentMapper.insert(department);
//        }else {  //否则为更新
//            return departmentMapper.update(department);
//        }
//    }
}
