package com.example.efub.seminar07.web.dto;

import com.example.efub.seminar07.domain.User;
import com.example.efub.seminar07.domain.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor
public class UserSaveRequestDTO {
    private String name;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @Builder
    public UserSaveRequestDTO(String name, UserType type){
        this.name = name;
        this.type = type;
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .type(type)
                .build();
    }
}