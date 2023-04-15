package com.example.springboot.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author lhc
 * @since 2023-04-15
 */
@Getter
@Setter
  @ApiModel(value = "Teacher对象", description = "")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer tnumber;

    private String tname;

    private String tsex;

    private LocalDate tbirthday;

    private String tstatus;

    private String twage;

    private Integer tcollege;

    private String tusername;

    private String tpassword;

    private String avatarurl;


}
