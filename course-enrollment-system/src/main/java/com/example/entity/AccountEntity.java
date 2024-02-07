package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="TBL_ACCOUNT")
public class AccountEntity {

    @Id
    @Column(name="ACCOUNT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name="USERNAME")
    private String username;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="USER_TYPE")
    private String userType;

}
