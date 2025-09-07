package com.example.oca42.model;

import com.example.oca42.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Long id;
    private String username;
    private Integer age;
    private List<AddressResponseDto> addresses;
    private ContactResponseDto contact;
    private Set<Role> roles;
}
