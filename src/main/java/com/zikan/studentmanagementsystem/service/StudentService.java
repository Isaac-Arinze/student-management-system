package com.zikan.studentmanagementsystem.service;

import com.zikan.studentmanagementsystem.dto.StudentDto;
import com.zikan.studentmanagementsystem.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
}
