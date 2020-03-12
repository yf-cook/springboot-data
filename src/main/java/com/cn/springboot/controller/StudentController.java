package com.cn.springboot.controller;

import com.cn.springboot.bean.Student;
import com.cn.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//@RestController
public class StudentController {

    @Resource(name = "studentService")
    private StudentService studentService;

    @RequestMapping("/addStudent")
    public void studentOps(){
        Student student = new Student();
        student.setStudentName("老王");
        student.setStudentSex("男");
        int i = studentService.addStudent(student);
        System.out.println("addStudent>>"+i);
    }

    @RequestMapping(value = "/updateStudent")
    public void updateStudent(){
        Student student = new Student();
        student.setStudentId(1);
        student.setStudentName("老王来了");
        student.setStudentSex("女");
        int i = studentService.updateStudent(student);
        System.out.println("updateStudent>>"+i);
    }

    @RequestMapping(value = "/getAllStudent")
    public void getAllStudent(){
        List<Student> allStudent = studentService.getAllStudent();
        System.out.println("getAllStudent>>"+allStudent);
    }

}
