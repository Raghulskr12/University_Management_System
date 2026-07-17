package com.example.unimanage.controller;

import com.example.unimanage.model.StudentProfileModel;
import com.example.unimanage.service.StudentProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-profiles")
public class StudentProfileController {

    @Autowired
    private StudentProfileService studentProfileService;

    @PostMapping
    public ResponseEntity<StudentProfileModel> createStudentProfile(@Valid @RequestBody StudentProfileModel studentProfile) {
        return new ResponseEntity<>(studentProfileService.createStudentProfile(studentProfile), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentProfileModel>> getAllStudentProfiles() {
        return ResponseEntity.ok(studentProfileService.getAllStudentProfiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfileModel> getStudentProfileById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentProfileService.getStudentProfileById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentProfileModel> updateStudentProfile(@PathVariable Integer id, @Valid @RequestBody StudentProfileModel studentProfile) {
        return ResponseEntity.ok(studentProfileService.updateStudentProfile(id, studentProfile));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentProfile(@PathVariable Integer id) {
        studentProfileService.deleteStudentProfile(id);
        return ResponseEntity.noContent().build();
    }
}
