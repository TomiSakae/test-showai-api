package com.tomisakae.showai.services;

import com.tomisakae.showai.models.User;
import com.tomisakae.showai.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id)
            .map(existingUser -> {
                existingUser.setUsername(userDetails.getUsername());
                existingUser.setEmail(userDetails.getEmail());
                existingUser.setPassword(userDetails.getPassword());
                return userRepository.save(existingUser);
            });
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
