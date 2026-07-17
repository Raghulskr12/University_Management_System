package com.example.unimanage.repository;

import com.example.unimanage.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, Integer> {
}
