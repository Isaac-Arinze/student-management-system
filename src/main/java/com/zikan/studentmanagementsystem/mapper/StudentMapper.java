package com.zikan.studentmanagementsystem.mapper;

import com.zikan.studentmanagementsystem.dto.StudentDto;
import com.zikan.studentmanagementsystem.entity.Student;

public class StudentMapper {

//    We are converting student dto to java object
    public static StudentDto mapToStudentSto(Student student){
        StudentDto studentDto = new StudentDto(

        student.getId(),
        student.getFirstName(),
        student.getLastName(),
        student.getEmail()
    );
    return studentDto;
}

    public static Student mapToStudent (StudentDto studentDto){
        Student  student = new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail()
        );
        return  student;
    }
}