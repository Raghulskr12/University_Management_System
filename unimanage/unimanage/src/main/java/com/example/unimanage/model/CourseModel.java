package com.example.unimanage.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30)
    private String name;
    
    @NotNull(message = "Credits are required")
    private Integer credits;
    
    @NotBlank(message = "Semester is required")
    private String semester;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentModel department;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<StudentModel> students;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<InstructorModel> instructors;
}
