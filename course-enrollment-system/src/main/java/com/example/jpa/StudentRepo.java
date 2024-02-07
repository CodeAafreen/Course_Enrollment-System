package com.example.jpa;

import com.example.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
}
