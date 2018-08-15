package com.atguigu.mp.beans;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * @author susheng
 * @create 2018-08-07 21:39
 **/
/**
 * 一般类型的默认为0 false，而mybatis-plus需要的默认值null，所以这里最好用包装类型。
 */
@Data
//@TableName("tbl_employee")
public class Employee {
//  @TableId(value = "id",type = IdType.AUTO)
  private Integer id;
//  @TableField("last_name")
  private String lastName;
  private String email;
  private Integer gender;
  private Integer age;
  @TableLogic
  private Integer delFlag;

}
