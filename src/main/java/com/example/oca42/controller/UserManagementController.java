package com.example.oca42.controller;

import com.example.oca42.model.UserResponseDto;
import com.example.oca42.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserManagementController {

    private final UserService userManagementService;

    //get all users

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userManagementService.getAllUsers();
    }

}
