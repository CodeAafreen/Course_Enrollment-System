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
@Table(name = "TBL_STUDENT")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private Long id;

    @Column(name = "STUDENT_NAME")
    private String studentsName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ACCOUNT_ID")
    private AccountEntity accountEntity;

    @ManyToMany
    @JoinTable(
            name = "course_like",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private List<CourseEntity> courseEntityList;
}
