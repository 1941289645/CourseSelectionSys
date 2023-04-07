package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

// @Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
//    @Select("select * from department")
//    List<Department> findAll();
//
//    @Insert("insert into department(deptid, deptname, address, phonecode) " +
//            "values (#{deptid},#{deptname},#{address},#{phonecode})")
//    int insert(Department department);
//
//    int update(Department department);
//
//    @Delete("delete from department where deptid = #{deptid}")
//    Integer deleteById(@Param("deptid") Integer deptid);  //Param参数让框架找到参数叫什么名字，"id"和#{id}一一对应，可以和id不一样，一般多个参数才要写
//
//    @Select("select * from department where deptname like concat('%',#{deptname},'%') and address like concat('%',#{address},'%') and phonecode like concat('%',#{phonecode},'%') limit #{pageNum},#{pageSize}")
//    List<Department> selectPage(Integer pageNum, Integer pageSize,String deptname, String address,String phonecode);
//
//    @Select("select count(*) from department where deptname like concat('%',#{deptname},'%') and address like concat('%',#{address},'%') and phonecode like concat('%',#{phonecode},'%')")
//    Integer selectTotal(String deptname,String address,String phonecode);
}
