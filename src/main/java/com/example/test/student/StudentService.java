package com.example.test.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository employeeRepository;

    public List<Student> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Student getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Student createOrUpdateEmployee(Student student) {
        return employeeRepository.save(student);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

