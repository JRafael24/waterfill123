package com.Thesis.waterfill.Controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Thesis.waterfill.DTO.RegistrationRequest;
import com.Thesis.waterfill.Model.Role;
import com.Thesis.waterfill.Model.User;
import com.Thesis.waterfill.Repository.RoleRepository;
import com.Thesis.waterfill.Repository.UserRepository;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity <?> register (@RequestBody RegistrationRequest registrationRequest){
            if(userRepository.existsByUsername(registrationRequest.getUsername())){
                return new ResponseEntity<>("Username is already taken", HttpStatus.BAD_REQUEST);
            }
            if(userRepository.existsByEmail(registrationRequest.getEmail())){
                return new ResponseEntity<>("An account is already registered in this email", HttpStatus.BAD_REQUEST);
            }
    

    User user = new User(
        registrationRequest.getUsername(),
        registrationRequest.getEmail(),
        passwordEncoder.encode(registrationRequest.getPassword())

    );

    Role role = roleRepository.findByName("ROLE_ADMID").get();
    user.setRoles(Collections.singleton(role));

    userRepository.save(user);
    return new ResponseEntity<>("User registered successfully!",HttpStatus.OK);

}
}
