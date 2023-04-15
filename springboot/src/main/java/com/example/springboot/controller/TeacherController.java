package com.example.springboot.controller;


import com.example.springboot.entity.Teacher;
import com.example.springboot.service.ITeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhc
 * @since 2023-04-15
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private ITeacherService teacherService;

    //新增和修改
    @PostMapping
    public boolean save(@RequestBody Teacher teacher){//@RequestBody将前台josn对象转换为后台的java对象
        //新增或者更新
        return teacherService.saveOrUpdate(teacher);
    }

    //删除指定deptid的数据
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){  //@PathVariable这个注解表示上面url这个参数，上面花括号里面的id和这个参数id是一一对应的
        return teacherService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> deptids){
        return teacherService.removeByIds(deptids);
    }

    //查询所有数据
    @GetMapping
    public List<Teacher> findAll(){
        //List<Department> all=departmentMapper.findAll();
        return teacherService.list();
    }

    @GetMapping("/{id}")
    public Teacher findeOne(@PathVariable Integer id){
        return teacherService.getById(id);
    }

    //分页查询-mybatis-plus的方式进行
//    @GetMapping("/page")
//    public Page<Teacher> findPage(@RequestParam Integer pageNum,
//                                    @RequestParam Integer pageSize){
//        QueryWrapper<Teacher> queryWrapper= new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");
//        return teacherService.page(new Page<>(pageNum,pageSize),queryWrapper);
//    }

}

