package org.example.ecommerceapp.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.ecommerceapp.models.User;
import org.example.ecommerceapp.repository.UserRepository;
import org.example.ecommerceapp.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        if(!userRepository.existsById(user.getId())){
            throw new EntityNotFoundException("User not found with id: "+user.getId());
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User updateUserEmailById(Long id, String email) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User not found with id: " + id));
        if(user.getEmail().equalsIgnoreCase(email)){
            throw new IllegalArgumentException("Can not change the email!");
        }
        user.setEmail(email);
        return user;
    }
}
