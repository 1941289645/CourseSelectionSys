package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "department")
public class Department {

    @TableId(value = "deptid",type = IdType.AUTO)
    private Integer deptid;
    private String deptname;
    private String address;
    private String phonecode;

// @JsonIgnore  忽略某个字段不展示给前端
}