package com.example.efub.seminar07.web.dto;

import com.example.efub.seminar07.domain.User;
import com.example.efub.seminar07.domain.UserType;
import com.example.efub.seminar07.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/test/{id}")
    private UserResponseDTO findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void userNotFoundHandler(IllegalArgumentException e){}


    @PostMapping("/test/{name}")
    private User save(@PathVariable String name){
        UserSaveRequestDTO requestDTO = UserSaveRequestDTO.builder()
                .name(name)
                .type(UserType.NORMAL)
                .build();
        return userService.save(requestDTO);
    }


}
