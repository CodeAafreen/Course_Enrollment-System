package com.example.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherDto {

    private Long id;

    private String teacherName;

    private AccountDto accountDto;

}
