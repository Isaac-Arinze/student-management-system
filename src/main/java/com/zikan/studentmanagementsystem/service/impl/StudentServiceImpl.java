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

        List<StudentDto> studentDtos = students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentDto) {
//        convert studentdto to student JPA entity
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {

        Student student = studentRepository.findById(studentId).get();
//        convert student object to studentDto
        StudentDto studentDto = StudentMapper.mapToStudentDto(student);
        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
//        convert studentdto to student Jpa
        studentRepository.save(StudentMapper.mapToStudent(studentDto));


    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
