package com.example.efub.seminar07.web.dto;

import com.example.efub.seminar07.domain.User;
import com.example.efub.seminar07.domain.UserType;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
public class UserResponseDTO {
    private String name;

    @Enumerated(EnumType.STRING)
    private UserType type;

    public UserResponseDTO(User entity){
        this.name = entity.getName();
        this.type = entity.getType();
    }
}