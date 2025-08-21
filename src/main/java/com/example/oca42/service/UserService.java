package com.example.oca42.service;

import com.example.oca42.model.UserResponseDto;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getAllUsers();
}
