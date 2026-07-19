package com.example.unimanage.controller;

import com.example.unimanage.model.StudentModel;
import com.example.unimanage.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.unimanage.model.CourseModel;
import com.example.unimanage.model.StudentProfileModel;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentModel> createStudent(@Valid @RequestBody StudentModel student) {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentModel>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentModel> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentModel> updateStudent(@PathVariable Integer id, @Valid @RequestBody StudentModel student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    // --- Relationship Endpoints ---

    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<StudentModel> enrollInCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        return ResponseEntity.ok(studentService.enrollInCourse(studentId, courseId));
    }

    @DeleteMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<StudentModel> dropCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        return ResponseEntity.ok(studentService.dropCourse(studentId, courseId));
    }

    @GetMapping("/{studentId}/courses")
    public ResponseEntity<List<CourseModel>> getStudentCourses(@PathVariable Integer studentId) {
        return ResponseEntity.ok(studentService.getStudentCourses(studentId));
    }

    @GetMapping("/{studentId}/profile")
    public ResponseEntity<StudentProfileModel> getStudentProfile(@PathVariable Integer studentId) {
        StudentModel student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(student.getStudentProfile());
    }

    @PutMapping("/{studentId}/profile")
    public ResponseEntity<StudentModel> updateStudentProfile(
            @PathVariable Integer studentId, 
            @Valid @RequestBody StudentProfileModel profile) {
        return ResponseEntity.ok(studentService.updateStudentProfile(studentId, profile));
    }

    @PutMapping("/{studentId}/department/{departmentId}")
    public ResponseEntity<StudentModel> transferDepartment(
            @PathVariable Integer studentId, 
            @PathVariable Integer departmentId) {
        return ResponseEntity.ok(studentService.transferDepartment(studentId, departmentId));
    }
}
