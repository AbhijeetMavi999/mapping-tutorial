package com.orm.service.impl;

import com.orm.entity.Address;
import com.orm.entity.Student;
import com.orm.repository.StudentRepository;
import com.orm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        // Set student reference in each address
        if (student.getAddresses() != null) {
            for (Address address : student.getAddresses()) {
                address.setStudent(student);
            }
        }

        // Set student reference in laptop
        if (student.getLaptop() != null) {
            student.getLaptop().setStudent(student);
        }

        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> findStudentByNameAndCity(String studentName, String city) {
        List<Student> students = studentRepository
                .findByStudentNameStartsWithIgnoreCaseAndAddresses_CityIgnoreCase(studentName, city);
        return students;
    }
}
