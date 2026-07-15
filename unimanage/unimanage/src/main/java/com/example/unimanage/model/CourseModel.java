package com.example.unimanage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CourseModel {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Integer credits;
    private String semester;
}
