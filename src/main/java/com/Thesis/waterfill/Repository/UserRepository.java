package com.Thesis.waterfill.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Thesis.waterfill.Model.User;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameOrEmail (String email, String username);

    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);


}
