package com.example.unimanage.service;

import com.example.unimanage.model.CourseModel;
import com.example.unimanage.repository.CourseRepository;
import com.example.unimanage.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseModel createCourse(CourseModel course) {
        return courseRepository.save(course);
    }

    public List<CourseModel> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseModel getCourseById(Integer id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
    }

    public CourseModel updateCourse(Integer id, CourseModel courseDetails) {
        CourseModel course = getCourseById(id);
        course.setName(courseDetails.getName());
        course.setCredits(courseDetails.getCredits());
        course.setSemester(courseDetails.getSemester());
        // Note: Managing relationships (department, students, instructors) can be added here as needed
        return courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {
        CourseModel course = getCourseById(id);
        courseRepository.delete(course);
    }
}
