package com.example.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {

    private Long id;

    private String studentName;

    private AccountDto accountDto;

}
