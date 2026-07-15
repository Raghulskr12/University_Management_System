package com.example.unimanage.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer credits;
    private String semester;
}
