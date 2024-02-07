package com.example.repository;

import com.example.entity.StudentEntity;
import com.example.jpa.StudentRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class StudentRepoImpl implements StudentRepo {
}
