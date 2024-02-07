package com.example.jpa;

import com.example.entity.CourseEntity;
import com.example.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<CourseEntity, Long> {
}
