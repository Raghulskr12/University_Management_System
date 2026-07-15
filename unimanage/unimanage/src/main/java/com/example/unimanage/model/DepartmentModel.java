package com.example.unimanage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DepartmentModel {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String hod;
}
