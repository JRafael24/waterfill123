package com.Thesis.waterfill.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Thesis.waterfill.Model.UserDatail;

public interface UserDatailRepository extends JpaRepository<UserDatail, Long> {
    Optional<UserDatail> findByPhoneNumber(String phoneNumber);
}


