package com.orm.controller;

import com.orm.entity.Student;
import com.orm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/findByNameAndCity/{studentName}/{city}")
    public ResponseEntity<List<Student>> findStudentByNameAndCity(@PathVariable String studentName,
                                                                  @PathVariable String city) {
        List<Student> students = studentService.findStudentByNameAndCity(studentName, city);
        return new ResponseEntity<>(students, HttpStatus.FOUND);
    }
}
