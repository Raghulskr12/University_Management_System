package com.example.unimanage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "studentsProfile")
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer marks;
    private String address;
}
