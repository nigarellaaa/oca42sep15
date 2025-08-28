package com.example.oca42.repository;

import com.example.oca42.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findOneById(Long id);

    boolean existsByUsername(String username);
}
