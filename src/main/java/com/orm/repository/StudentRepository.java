package com.orm.repository;

import com.orm.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByStudentNameStartsWithIgnoreCaseAndAddresses_CityIgnoreCase(String studentName, String city);
}