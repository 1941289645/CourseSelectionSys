package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.Department;
import com.example.springboot.mapper.DepartmentMapper;
import com.example.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //新增和修改
    @PostMapping
    public boolean save(@RequestBody Department department){//@RequestBody将前台josn对象转换为后台的java对象
        //新增或者更新
        return departmentService.saveDepartment(department);
    }

    //查询所有数据
    @GetMapping
    public List<Department> findAll(){
        //List<Department> all=departmentMapper.findAll();
        return departmentService.list();
    }

    //删除指定deptid的数据
    @DeleteMapping("/{deptid}")
    public boolean delete(@PathVariable Integer deptid){  //@PathVariable这个注解表示上面url这个参数，上面花括号里面的id和这个参数id是一一对应的
        return departmentService.removeById(deptid);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> deptids){  //[1,2,3]
        return departmentService.removeByIds(deptids);
    }
    //分页查询
    //接口路径:/department/page?pageNum=1&pageSize=10
    //@RequestParam接收 ?pageNum=1&pageSize=10，映射入参数
    //limit第一个参数 = (pageNum-1)*pageSize
//    @GetMapping("/page")
//    public Map<String,Object> findPage(@RequestParam Integer pageNum,
//                                       @RequestParam Integer pageSize,
//                                       @RequestParam String deptname,
//                                       @RequestParam String address,
//                                       @RequestParam String phonecode){
//        pageNum=(pageNum-1)*pageSize;
//        List<Department> data=departmentMapper.selectPage(pageNum,pageSize, deptname,address,phonecode);
//        Integer total=departmentMapper.selectTotal(deptname,address,phonecode);
//        Map<String,Object> res=new HashMap<>();
//        res.put("data",data);
//        res.put("total",total);
//        return res;
//    }

    //分页查询-mybatis-plus的方式进行
    @GetMapping("/page")
    public IPage<Department> findPage(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize,
                                       @RequestParam (defaultValue = "")String deptname,
                                       @RequestParam (defaultValue = "")String address,
                                       @RequestParam (defaultValue = "")String phonecode){
        IPage<Department> page =new Page<>(pageNum,pageSize);
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
        return departmentService.page(page,queryWrapper);
    }

}
