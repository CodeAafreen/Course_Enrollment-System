package com.example.jpa;

import com.example.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<TeacherEntity, Long> {
}
