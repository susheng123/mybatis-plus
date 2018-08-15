package com.atguigu.mp;

import static org.junit.Assert.assertTrue;

import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper = (EmployeeMapper) ac.getBean("employeeMapper");



    @Test
    public void testPage() {
        Page<Employee> page = new Page<>(2, 2);
        List<Employee> employees = employeeMapper.selectPage(page, null);
        System.out.println(employees);
        System.out.println("总条数:"+page.getTotal());
        System.out.println("当前页数:"+page.getCurrent());
    }

    @Test
    public void testEw4() {
        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>().eq("gender", 1)
//        .orderBy("age")
//        .orderDesc(Arrays.asList("age"))
                .orderBy("age").last("desc limit 2")
        );
        System.out.println(employees);

    }

    @Test
    public void testEw3() {
        Employee t = new Employee();
        t.setEmail("bbb@qq.com");
        employeeMapper.update(t,new EntityWrapper<Employee>().eq("last_name","sheng").eq("age",19));
    }

    @Test
    public void delete() {
        employeeMapper.delete(new EntityWrapper<Employee>().eq("last_name","kkkkkkkkkkkkkkkkk"));
    }

    @Test
    public void testEw1() {
        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>().eq("last_name", "sheng").orNew().
                like("email", "a").eq("age",22));
        //or()  WHERE (last_name = ? AND email LIKE ? OR age = ?)
        //orNew() WHERE (last_name = ? AND email LIKE ?) OR (age = ?)
        System.out.println(employees);
    }

    @Test
    public void testEw() {
        List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(1, 5), new EntityWrapper<Employee>()
                .between("age", 1, 50).eq("last_name", "sheng").notLike("email","a"));
        System.out.println(employees);
    }

    @Test
    public void testDelete() {
        Integer result = employeeMapper.deleteById(1);
        System.out.println(result);

    }

    @Test
    public void testSelect() {
        Employee employee = employeeMapper.selectById(1);
//        Employee t = new Employee();
//        t.setEmail("243@qq.com");
//        t.setLastName("sheng1");
//        Employee employee = employeeMapper.selectOne(t);
        System.out.println(employee);
    }
    @Test
    public void testSelect1() {
//
//        List<Integer> list = Arrays.asList(5, 6, 7);
//        List<Employee> employees = employeeMapper.selectBatchIds(list);
//        System.out.println(employees);

//        Map<String, Object> map = new HashMap<>();
//        map.put("last_name","sheng");
//        List<Employee> employees = employeeMapper.selectByMap(map);
//        System.out.println(employees);


    }


    @Test
    public void testUpdate() {
        Employee employee = new Employee();
        employee.setId(9);
        employee.setLastName("kkkkkkkkkkkkkkkkk");
//        employee.setEmail("wwwwwwwwwwwwww");
//        employee.setGender(0);
//        employee.setAge(0);
        employeeMapper.updateAllColumnById(employee);

    }


    @Test
    public void testInsert() throws SQLException {
//        DataSource dataSource = (DataSource) ac.getBean("dataSource");
//        System.out.println(dataSource.getConnection());

        Employee employee = new Employee();
//        employee.setLastName("sheng");
//        employee.setEmail("243@qq.com");
        employee.setGender(0);
        employee.setAge(18);

//        System.out.println(employeeMapper.insert(employee));
        System.out.println(employeeMapper.insertAllColumn(employee));
        System.out.println("主键id="+employee.getId());
    }
}
