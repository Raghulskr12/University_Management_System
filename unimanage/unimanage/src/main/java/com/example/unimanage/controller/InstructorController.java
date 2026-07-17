package com.example.unimanage.controller;

import com.example.unimanage.model.InstructorModel;
import com.example.unimanage.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<InstructorModel> createInstructor(@Valid @RequestBody InstructorModel instructor) {
        return new ResponseEntity<>(instructorService.createInstructor(instructor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InstructorModel>> getAllInstructors() {
        return ResponseEntity.ok(instructorService.getAllInstructors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorModel> getInstructorById(@PathVariable Integer id) {
        return ResponseEntity.ok(instructorService.getInstructorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstructorModel> updateInstructor(@PathVariable Integer id, @Valid @RequestBody InstructorModel instructor) {
        return ResponseEntity.ok(instructorService.updateInstructor(id, instructor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Integer id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }
}
