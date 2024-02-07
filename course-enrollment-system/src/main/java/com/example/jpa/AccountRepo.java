package com.example.jpa;

import com.example.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

public interface AccountRepo extends JpaRepository<AccountEntity, Long> {
    AccountEntity findByUsername(String username);
}
