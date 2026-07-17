package com.example.unimanage.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@Table(name = "instructors")
@NoArgsConstructor
@AllArgsConstructor
public class InstructorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30)
    private String name;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentModel department;

    @ManyToMany
    @JoinTable(
        name = "instructor_courses",
        joinColumns = @JoinColumn(name = "instructor_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<CourseModel> courses;
}
