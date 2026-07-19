package com.example.unimanage.service;

import com.example.unimanage.model.StudentModel;
import com.example.unimanage.repository.StudentRepository;
import com.example.unimanage.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.unimanage.model.CourseModel;
import com.example.unimanage.model.DepartmentModel;
import com.example.unimanage.model.StudentProfileModel;
import com.example.unimanage.repository.CourseRepository;
import com.example.unimanage.repository.DepartmentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

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
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        StudentModel student = getStudentById(id);
        studentRepository.delete(student);
    }


    public StudentModel enrollInCourse(Integer studentId, Integer courseId) {
        StudentModel student = getStudentById(studentId);
        CourseModel course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));
        
        student.getCourses().add(course);
        return studentRepository.save(student);
    }

    public StudentModel dropCourse(Integer studentId, Integer courseId) {
        StudentModel student = getStudentById(studentId);
        CourseModel course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));
        
        student.getCourses().remove(course);
        return studentRepository.save(student);
    }

    public List<CourseModel> getStudentCourses(Integer studentId) {
        StudentModel student = getStudentById(studentId);
        return student.getCourses();
    }

    public StudentModel updateStudentProfile(Integer studentId, StudentProfileModel updatedProfile) {
        StudentModel student = getStudentById(studentId);
        StudentProfileModel existingProfile = student.getStudentProfile();
        
        if (existingProfile != null) {
            existingProfile.setMarks(updatedProfile.getMarks());
            existingProfile.setAddress(updatedProfile.getAddress());
        } else {
            student.setStudentProfile(updatedProfile);
        }
        
        return studentRepository.save(student);
    }

    public StudentModel transferDepartment(Integer studentId, Integer departmentId) {
        StudentModel student = getStudentById(studentId);
        DepartmentModel department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));
        
        student.setDepartment(department);
        return studentRepository.save(student);
    }
}
