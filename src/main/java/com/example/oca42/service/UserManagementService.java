package com.example.oca42.service;

import com.example.oca42.entity.Address;
import com.example.oca42.entity.UserAccount;
import com.example.oca42.exception.AlreadyExistException;
import com.example.oca42.exception.NotFoundException;
import com.example.oca42.model.AddressRequestDto;
import com.example.oca42.model.UserCreateRequestDto;
import com.example.oca42.model.UserResponseDto;
import com.example.oca42.model.UserUpdateRequestDto;
import com.example.oca42.repository.ContactRepository;
import com.example.oca42.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManagementService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ContactRepository contactRepository;
    private final RoleService roleService;

    public List<UserResponseDto> getAllUsers() {
        List<UserAccount> all = userRepository.findAll();
        return all.stream().map(u -> modelMapper.map(u, UserResponseDto.class)).toList();
    }

    public UserResponseDto getById(Long id) {

        Optional<UserAccount> byId1 = userRepository.getUserAccountById(id);
        UserAccount userAccount = byId1.orElseThrow(() -> new NotFoundException("User not found"));
        return modelMapper.map(userAccount, UserResponseDto.class);
    }


    public void create(UserCreateRequestDto requestDto) {
        if (userRepository.existsByUsername(requestDto.getUsername())) {
            throw new AlreadyExistException("Username already exists");
        }

        UserAccount map = modelMapper.map(requestDto, UserAccount.class);
        userRepository.save(map);

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    public void updateUser(Long id, UserUpdateRequestDto userUpdateRequestDto) {
        userRepository.getUserAccountById(id).ifPresent(user -> {
            user.setAge(userUpdateRequestDto.getAge());
            user.setRoles(roleService.getAllById(userUpdateRequestDto.getRoleIds()));
            userRepository.save(user);
        });
    }

    public void addNewAddressToUser(Long userId, AddressRequestDto requestDto) {
        userRepository.getUserAccountById(userId).ifPresent(user -> {
            Address address = modelMapper.map(requestDto, Address.class);
            user.addAddress(address);
            userRepository.save(user);
        });
    }

    public void removeUserAddress(Long userId, Long addressId) {
        userRepository.getUserAccountById(userId).ifPresent(user -> {

            user.removeAddress(getAddress(addressId));

            userRepository.save(user);
        });
    }

    private Address getAddress(Long addressId) {
        //fetch address from repo by id
        Address address = new Address();
        address.setId(addressId);
        return address;
    }

    public UserAccount getUserByUsername(String username) {
        return userRepository.getUserAccountByUsername(username).orElseThrow(
                () -> new NotFoundException("User not found")
        );
    }
}
