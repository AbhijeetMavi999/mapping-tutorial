package com.orm.service;

import com.orm.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Integer studentId);

    void deleteStudent(Integer studentId);

    List<Student> findStudentByNameAndCity(String studentName, String city);
}
