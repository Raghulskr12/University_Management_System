package com.example.unimanage.service;

import com.example.unimanage.model.DepartmentModel;
import com.example.unimanage.repository.DepartmentRepository;
import com.example.unimanage.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.unimanage.model.CourseModel;
import com.example.unimanage.model.StudentModel;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentModel createDepartment(DepartmentModel department) {
        return departmentRepository.save(department);
    }

    public List<DepartmentModel> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public DepartmentModel getDepartmentById(Integer id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    }

    public DepartmentModel updateDepartment(Integer id, DepartmentModel departmentDetails) {
        DepartmentModel department = getDepartmentById(id);
        department.setName(departmentDetails.getName());
        department.setHod(departmentDetails.getHod());
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Integer id) {
        DepartmentModel department = getDepartmentById(id);
        departmentRepository.delete(department);
    }

    public List<StudentModel> getDepartmentStudents(Integer id) {
        DepartmentModel department = getDepartmentById(id);
        return department.getStudents();
    }

    public List<CourseModel> getDepartmentCourses(Integer id) {
        DepartmentModel department = getDepartmentById(id);
        return department.getCourses();
    }
}
