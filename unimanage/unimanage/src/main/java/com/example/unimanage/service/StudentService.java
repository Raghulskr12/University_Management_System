package com.example.unimanage.service;

import com.example.unimanage.model.StudentModel;
import com.example.unimanage.repository.StudentRepository;
import com.example.unimanage.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentModel createStudent(StudentModel student) {
        return studentRepository.save(student);
    }

    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentModel getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    public StudentModel updateStudent(Integer id, StudentModel studentDetails) {
        StudentModel student = getStudentById(id);
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setPhoneNumber(studentDetails.getPhoneNumber());
        student.setAge(studentDetails.getAge());
        // Managing relationships can be added here
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        StudentModel student = getStudentById(id);
        studentRepository.delete(student);
    }
}
