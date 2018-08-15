package com.atguigu.mp.mapper;

import com.atguigu.mp.beans.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * @author susheng
 * @create 2018-08-07 22:20
 **/

public interface EmployeeMapper extends BaseMapper<Employee> {
    void deleteAll();
}
