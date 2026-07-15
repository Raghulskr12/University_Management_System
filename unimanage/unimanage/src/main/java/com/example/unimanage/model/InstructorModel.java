package com.example.unimanage.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String email;
}
