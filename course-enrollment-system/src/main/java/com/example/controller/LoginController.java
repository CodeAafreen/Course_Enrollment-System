package com.example.controller;

import com.example.dto.AccountDto;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/")
    @CrossOrigin
    private ResponseEntity<AccountDto> findByUserName(@RequestBody AccountDto accountDto){
        AccountDto account = accountService.findAccount(accountDto);
        if(account.getPassword().equals(accountDto.getPassword())){
            return new ResponseEntity<>(accountDto, HttpStatus.OK);
        }
        return null;
    }
}
