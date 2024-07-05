package com.Thesis.waterfill.Service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Thesis.waterfill.Model.User;
import com.Thesis.waterfill.Repository.UserRepository;

@Service
public class CustomerUserDetailService  implements UserDetailsService{
    private UserRepository userRepository;

    public CustomerUserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String usernameOremail) throws UsernameNotFoundException{
        User user = userRepository.findByUsernameOrEmail(usernameOremail, usernameOremail)
        .orElseThrow(() ->
        new UsernameNotFoundException("User not found with username or email" + usernameOremail));
        Set<GrantedAuthority> authorities= user
        .getRoles()
        .stream()
        .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPassword(),
            authorities
        );
    }

}
