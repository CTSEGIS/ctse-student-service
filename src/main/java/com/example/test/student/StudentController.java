package com.example.test.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllEmployees() {
        return studentService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getEmployeeById(@PathVariable Long id) {
        Student student = studentService.getEmployeeById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Student> createEmployee(@RequestBody Student student) {
        Student createdStudent = studentService.createOrUpdateEmployee(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateEmployee(@PathVariable Long id, @RequestBody Student student) {
        //student.setId(id); // Ensure the correct ID is set
        Student updatedStudent = studentService.createOrUpdateEmployee(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        studentService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
