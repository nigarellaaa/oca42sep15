package com.example.oca42.service;

import com.example.oca42.entity.UserAccount;
import com.example.oca42.model.UserResponseDto;
import com.example.oca42.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManagementServiceV2 implements UserService {

    private final UserRepository userRepository;

    //ModelMapper/ MapStruct/Remondis-remap/

    @Override
    public List<UserResponseDto> getAllUsers() {
        System.out.println("New implementation");
        List<UserAccount> all = userRepository.findAll();
        return all.stream()
                .map(u -> new UserResponseDto(u.getId(), u.getUsername(), u.getAge()))
                .toList();
    }
}
