package com.example.oca42.service;

import com.example.oca42.entity.UserAccount;
import com.example.oca42.model.UserResponseDto;
import com.example.oca42.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManagementService implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    //ModelMapper/ MapStruct/Remondis-remap/

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserAccount> all = userRepository.findAll();
        return all.stream()
                .map(u -> modelMapper.map(u, UserResponseDto.class))
                .toList();
    }

    //Optional<T>
    @Override
    public UserResponseDto getById(Long id) {
        return modelMapper.map(userRepository.findById(id).get(), UserResponseDto.class);
    }
}
