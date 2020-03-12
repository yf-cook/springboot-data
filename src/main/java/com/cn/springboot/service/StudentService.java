package com.cn.springboot.service;

import com.cn.springboot.bean.Student;
import com.cn.springboot.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    //增加一个学生的对象
    public int addStudent(Student student){
        return studentDao.addStudent(student);
    }

    //修改一个学生的对象信息
    public int updateStudent(Student student){
        return studentDao.updateStudent(student);
    }

    //查询所有学生的信息
    public List<Student> getAllStudent(){
        return studentDao.getAllStudent();
    }
}
