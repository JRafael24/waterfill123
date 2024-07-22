package com.Thesis.waterfill.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Thesis.waterfill.Model.UserDetail;
import java.util.List;



public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    Optional<UserDetail> findByPhoneNumber(String phoneNumber);
    UserDetail  findByUserId(Long userId);
}


