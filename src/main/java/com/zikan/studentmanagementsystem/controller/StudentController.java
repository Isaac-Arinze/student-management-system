package com.zikan.studentmanagementsystem.controller;

import com.zikan.studentmanagementsystem.dto.StudentDto;
import com.zikan.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents (Model model){
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("Students", students);

        return "students";
    }
}
