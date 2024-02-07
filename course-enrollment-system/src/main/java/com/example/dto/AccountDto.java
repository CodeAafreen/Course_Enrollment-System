package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

    @JsonProperty("accountType")
    private String accountType;
}
