package com.example.unimanage.service;

import com.example.unimanage.model.InstructorModel;
import com.example.unimanage.repository.InstructorRepository;
import com.example.unimanage.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public InstructorModel createInstructor(InstructorModel instructor) {
        return instructorRepository.save(instructor);
    }

    public List<InstructorModel> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public InstructorModel getInstructorById(Integer id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id: " + id));
    }

    public InstructorModel updateInstructor(Integer id, InstructorModel instructorDetails) {
        InstructorModel instructor = getInstructorById(id);
        instructor.setName(instructorDetails.getName());
        instructor.setEmail(instructorDetails.getEmail());
        return instructorRepository.save(instructor);
    }

    public void deleteInstructor(Integer id) {
        InstructorModel instructor = getInstructorById(id);
        instructorRepository.delete(instructor);
    }
}
