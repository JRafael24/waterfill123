package com.Thesis.waterfill.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Thesis.waterfill.Model.UserDetail;
import com.Thesis.waterfill.NotFoundException.UserDetailNotFoundException;
import com.Thesis.waterfill.Repository.UserDetailRepository;

@RestController
@RequestMapping("/api/v1/profile")
public class UserDetailController {
    
    private final UserDetailRepository repo;

    public UserDetailController(UserDetailRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<UserDetail> getAllProfiles() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public UserDetail getProfileById(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new UserDetailNotFoundException(id));
    }

    @GetMapping("/account/{userId}")
    public UserDetail getProfileByUserDetail(@PathVariable Long userId) {
        return repo.findByUserId(userId);
    }

    @GetMapping("/phone/{phoneNumber}")
    public UserDetail getProfileByPhoneNumber(@PathVariable String phoneNumber) {
        return repo.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new UserDetailNotFoundException("Profile with phone number " + phoneNumber + " not found"));
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
