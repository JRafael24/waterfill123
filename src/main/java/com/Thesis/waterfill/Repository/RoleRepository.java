package com.Thesis.waterfill.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Thesis.waterfill.Model.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);

}
