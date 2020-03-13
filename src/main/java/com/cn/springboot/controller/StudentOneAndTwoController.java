package com.cn.springboot.controller;

import com.cn.springboot.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StudentOneAndTwoController {

    @Resource(name = "jdbcTemplateOne")
    private JdbcTemplate jdbcTemplateOne;
    @Autowired
    @Qualifier("jdbcTemplateTwo")
    private JdbcTemplate jdbcTemplateTwo;

    @RequestMapping(value = "/test")
    public void test(){
        List<Student> student1 = jdbcTemplateOne.query("select * from student", new BeanPropertyRowMapper<>(Student.class));
        List<Student> student2 = jdbcTemplateTwo.query("select * from student", new BeanPropertyRowMapper<>(Student.class));
        System.out.println("student1:"+student1);
        System.out.println("student2:"+student2);
    }

}
