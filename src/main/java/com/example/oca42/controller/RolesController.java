package com.example.oca42.controller;

import com.example.oca42.model.RoleResponseDto;
import com.example.oca42.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolesController {

    private final RoleService roleService;

    @GetMapping
    public List<RoleResponseDto> getRoles() {
        return roleService.getAll();
    }

    @DeleteMapping
    public void deleteById(Long id) {
        //delete
    }
}
