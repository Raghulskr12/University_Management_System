package com.example.unimanage.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name = "studentsProfile")
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "Marks are required")
    private Integer marks;

    @NotBlank(message = "Address is required")
    private String address;

    @OneToOne(mappedBy = "studentProfile")
    @JsonIgnore
    private StudentModel student;
}
