package com.example.oca42.repository;

import com.example.oca42.entity.UserAccount;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount, Long> {


    @Override
    @EntityGraph(attributePaths = {"contact", "addresses", "roles"})
    List<UserAccount> findAll();

    UserAccount findOneById(Long id);

    @EntityGraph(attributePaths = {"contact", "addresses", "roles"})
    Optional<UserAccount> getUserAccountById(Long id);

    @Query("""
                   select UserAccount
            from UserAccount ua1_0
                     left join ua1_0.contact
                     left join ua1_0.addresses
            where ua1_0.id = :id
            """)
    Optional<UserAccount> getCustom(@Param("id") Long userId);

    boolean existsByUsername(String username);
}
