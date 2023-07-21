package com.zikan.studentmanagementsystem.service.impl;

import com.zikan.studentmanagementsystem.dto.StudentDto;
import com.zikan.studentmanagementsystem.entity.Student;
import com.zikan.studentmanagementsystem.mapper.StudentMapper;
import com.zikan.studentmanagementsystem.repository.StudentRepository;
import com.zikan.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepository.findAll();

//        Convert to a Dto, we have

        List<StudentDto> studentDtos = students.stream().map((student) -> StudentMapper.mapToStudentSto(student))
                .collect(Collectors.toList());
        return studentDtos;
    }
}
