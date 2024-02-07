package com.example.controller;

import com.example.dto.AccountDto;
import com.example.entity.AccountEntity;
import com.example.entity.StudentEntity;
import com.example.entity.TeacherEntity;
import com.example.service.StudentService;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        if(accountDto != null){
            AccountEntity account = AccountEntity.builder()
                    .username(accountDto.getUsername())
                    .password(accountDto.getPassword())
                    .userType(accountDto.getAccountType())
                    .build();
            if(accountDto.getAccountType().equalsIgnoreCase("teacher")){
                TeacherEntity teacherEntity = TeacherEntity.builder()
                        .teachersName(accountDto.getName())
                        .accountEntity(account)
                        .build();

                teacherService.save(teacherEntity);
            }else if(accountDto.getAccountType().equalsIgnoreCase("student")){
                StudentEntity studentEntity = StudentEntity.builder()
                        .studentsName(accountDto.getName())
                        .accountEntity(account)
                        .build();

                studentService.save(studentEntity);
            }
        }

        return new ResponseEntity<AccountDto>(accountDto, HttpStatus.OK);
    }
}
