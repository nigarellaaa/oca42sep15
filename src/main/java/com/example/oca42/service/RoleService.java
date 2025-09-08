package com.example.oca42.service;

import com.example.oca42.entity.Role;
import com.example.oca42.model.RoleResponseDto;
import com.example.oca42.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repository;
    private final ModelMapper modelMapper;

    public Set<Role> getAllById(Set<Long> roleIds) {
        return Set.copyOf(repository.findAllById(roleIds));
    }

    public List<RoleResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(r -> modelMapper.map(r, RoleResponseDto.class))
                .toList();
    }
}
