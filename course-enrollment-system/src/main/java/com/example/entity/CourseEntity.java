package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TBL_COURSE")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID")
    private Long courseId;

    @Column(name = "COURSE_NAME")
    private String coursename;

    @Column(name = "MAX_STUDENT")
    private Long maxStudent;

    @Column(name = "MAX_TEACHER")
    private Long maxTeacher;

    @ManyToMany(mappedBy = "courseEntityList")
    private List<TeacherEntity> teacherEntityList;

    @ManyToMany(mappedBy = "courseEntityList")
    private List<StudentEntity> studentEntities;
}
