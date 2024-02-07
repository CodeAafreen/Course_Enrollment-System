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
@Table(name = "TBL_TEACHER")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEACHER_ID")
    private Long id;

    @Column(name = "TEACHER_NAME")
    private String teachersName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ACCOUNT_ID")
    private AccountEntity accountEntity;

    @ManyToMany
    @JoinTable(
            name = "course_like",
            joinColumns = @JoinColumn(name = "TEACHER_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private List<CourseEntity> courseEntityList;
}
