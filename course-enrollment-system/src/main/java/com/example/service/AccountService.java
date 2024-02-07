package com.example.service;

import com.example.dto.AccountDto;
import com.example.entity.AccountEntity;
import com.example.jpa.AccountRepo;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Resource
    private AccountRepo accountRepo;

    public ModelMapper mapper = new ModelMapper();

    public AccountDto findAccount(AccountDto accountDto){
        if (accountDto != null){
            AccountEntity byUsername = accountRepo.findByUsername(accountDto.getUsername());
            return mapper.map(byUsername, AccountDto.class);
        }

        return null;
    }


}
