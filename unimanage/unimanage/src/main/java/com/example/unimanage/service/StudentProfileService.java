package com.example.unimanage.service;

import com.example.unimanage.model.StudentProfileModel;
import com.example.unimanage.repository.StudentProfileRepository;
import com.example.unimanage.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    public StudentProfileModel createStudentProfile(StudentProfileModel studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }

    public List<StudentProfileModel> getAllStudentProfiles() {
        return studentProfileRepository.findAll();
    }

    public StudentProfileModel getStudentProfileById(Integer id) {
        return studentProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentProfile not found with id: " + id));
    }

    public StudentProfileModel updateStudentProfile(Integer id, StudentProfileModel studentProfileDetails) {
        StudentProfileModel studentProfile = getStudentProfileById(id);
        studentProfile.setMarks(studentProfileDetails.getMarks());
        studentProfile.setAddress(studentProfileDetails.getAddress());
        return studentProfileRepository.save(studentProfile);
    }

    public void deleteStudentProfile(Integer id) {
        StudentProfileModel studentProfile = getStudentProfileById(id);
        studentProfileRepository.delete(studentProfile);
    }
}
