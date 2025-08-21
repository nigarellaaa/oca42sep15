package com.example.oca42.configurations;

import com.example.oca42.repository.UserRepository;
import com.example.oca42.service.UserManagementService;
import com.example.oca42.service.UserManagementServiceV2;
import com.example.oca42.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CommonConfigurations {

    private final UserRepository userRepository;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
