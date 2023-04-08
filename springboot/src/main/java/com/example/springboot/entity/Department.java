package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author lhc
 * @since 2023-04-08
 */
@Getter
@Setter
  @ApiModel(value = "Department对象", description = "")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "deptid", type = IdType.AUTO)
      private Integer deptid;

    private String deptname;

    private String address;

    private String phonecode;


}
