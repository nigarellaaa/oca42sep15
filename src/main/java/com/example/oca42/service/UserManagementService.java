package com.example.oca42.service;

import com.example.oca42.entity.UserAccount;
import com.example.oca42.exception.AlreadyExistException;
import com.example.oca42.model.UserCreateRequestDto;
import com.example.oca42.model.UserResponseDto;
import com.example.oca42.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.rmi.AlreadyBoundException;
import java.util.List;
import java.util.Optional;

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

        Optional<UserAccount> byId1 = userRepository.findById(id);

        UserAccount userAccount = byId1.orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(userAccount, UserResponseDto.class);
    }

    @Override
    public void create(UserCreateRequestDto requestDto) {
        if(userRepository.existsByUsername(requestDto.getUsername())){
            throw new AlreadyExistException("Username already exists");
        }
        UserAccount map = modelMapper.map(requestDto, UserAccount.class);

        userRepository.save(map);
    }

}
