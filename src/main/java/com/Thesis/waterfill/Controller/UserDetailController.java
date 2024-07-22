package com.Thesis.waterfill.Controller;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Thesis.waterfill.Model.User;
import com.Thesis.waterfill.Model.UserDetail;
import com.Thesis.waterfill.NotFoundException.UserDetailNotFoundException;
import com.Thesis.waterfill.Repository.UserDetailRepository;
import com.Thesis.waterfill.Repository.UserRepository;

@RestController
@RequestMapping("/api/v1/profile")
public class UserDetailController {
    

  

    private final UserDetailRepository repo;
    private final UserRepository userRepository;

    public UserDetailController(UserDetailRepository repo, UserRepository userRepository) {
    this.repo = repo;
    this.userRepository = userRepository;
    }


    @GetMapping("account/{email}")
    public HashMap<String, String>getMail(@PathVariable String email) {
        User user = userRepository.findByEmail(email);
        UserDetail userDetail = repo.findByUserId(user.getId());

        HashMap<String, String> profile = new HashMap<String, String>();

        profile.put("name", user.getUsername());
        profile.put("mobileNumber", userDetail.getPhoneNumber());
        profile.put("address", userDetail.getAddress());

        return profile;


    }

    @PostMapping("/addinfo")
    public UserDetail createProfile(@RequestBody UserDetail newProfile) {
        return repo.save(newProfile);
    }

    @PutMapping("/edit/{id}")
    public UserDetail updateProfile(@PathVariable Long id, @RequestBody UserDetail updatedProfile) {
        return repo.findById(id)
                .map(profile -> {
                    profile.setPhoneNumber(updatedProfile.getPhoneNumber());
                    profile.setAddress(updatedProfile.getAddress());
                    return repo.save(profile);
                })
                .orElseThrow(() -> new UserDetailNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProfile(@PathVariable Long id) {
        repo.deleteById(id);
        return "Profile with ID " + id + " has been deleted";
    }
}
