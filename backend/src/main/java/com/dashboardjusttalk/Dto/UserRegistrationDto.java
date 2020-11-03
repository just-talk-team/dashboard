package com.dashboardjusttalk.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class UserRegistrationDto {
    public String user;
    public String password;
    @Column(nullable = false)
    public String name;
}
