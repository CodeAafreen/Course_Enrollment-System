package com.example.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {

    private Long id;


    private String coursename;

    private Long maxTeacher;

    private Long maxStudent;

    private List<StudentDto> studentDtoList;

    private List<TeacherDto> teacherDtolist;

}
