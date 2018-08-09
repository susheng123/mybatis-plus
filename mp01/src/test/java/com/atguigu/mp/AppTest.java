package com.atguigu.mp;

import static org.junit.Assert.assertTrue;

import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");



    @Test
    public void shouldAnswerWithTrue() throws SQLException {
//        DataSource dataSource = (DataSource) ac.getBean("dataSource");
//        System.out.println(dataSource.getConnection());
        EmployeeMapper employeeMapper = (EmployeeMapper) ac.getBean("employeeMapper");
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("sheng");
        employee.setEmail("243@qq.com");
        employee.setGender(0);
        employee.setAge(18);

        System.out.println(employeeMapper.insert(employee));
    }
}
