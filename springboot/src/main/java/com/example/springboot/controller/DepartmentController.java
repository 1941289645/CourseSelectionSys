package com.example.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.springboot.service.IDepartmentService;
import com.example.springboot.entity.Department;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhc
 * @since 2023-04-08
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private IDepartmentService departmentService;

    //新增和修改
    @PostMapping
    public boolean save(@RequestBody Department department){//@RequestBody将前台josn对象转换为后台的java对象
        //新增或者更新
        return departmentService.saveOrUpdate(department);
    }

    //删除指定deptid的数据
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){  //@PathVariable这个注解表示上面url这个参数，上面花括号里面的id和这个参数id是一一对应的
        return departmentService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> deptids){
        return departmentService.removeByIds(deptids);
    }

    //查询所有数据
    @GetMapping
    public List<Department> findAll(){
        //List<Department> all=departmentMapper.findAll();
        return departmentService.list();
    }

    @GetMapping("/{id}")
    public Department findeOne(@PathVariable Integer id){
        return departmentService.getById(id);
    }

    //分页查询-mybatis-plus的方式进行
    @GetMapping("/page")
    public Page<Department> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                     @RequestParam (defaultValue = "")String deptname,
                                     @RequestParam (defaultValue = "")String address,
                                     @RequestParam (defaultValue = "")String phonecode){
        QueryWrapper<Department> queryWrapper= new QueryWrapper<>();
        if(!"".equals(deptname)){
            queryWrapper.like("deptname",deptname);
        }
        if(!"".equals(address)){
            queryWrapper.like("address",address);
            //queryWrapper.and(w -> w.like("address",address));
        }
        if(!"".equals(phonecode)){
            queryWrapper.like("phonecode",phonecode);
        }
        queryWrapper.orderByDesc("deptid");
        return departmentService.page(new Page<>(pageNum,pageSize),queryWrapper);
    }

}

