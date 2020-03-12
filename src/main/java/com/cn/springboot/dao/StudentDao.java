package com.cn.springboot.dao;

import com.cn.springboot.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public class StudentDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //增加一个学生对象
    public int addStudent(Student student){
        return jdbcTemplate.update("insert into student(studentName,studentSex) values (?,?)",
                student.getStudentName(),student.getStudentSex());
    }

    //修改学生对象的信息
    public int updateStudent(Student student){
        return jdbcTemplate.update("update student set studentName=?,studentSex=? where studentId=?",
                student.getStudentName(),student.getStudentSex(),student.getStudentId());
    }

    //查询所有学生的信息
    public List<Student> getAllStudent(){
        return jdbcTemplate.query("select * from student",new BeanPropertyRowMapper<>(Student.class));
    }
}
