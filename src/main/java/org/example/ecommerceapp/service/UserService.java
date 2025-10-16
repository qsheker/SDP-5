package org.example.ecommerceapp.service;

import org.example.ecommerceapp.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService{
    User save(User user);

    User update(User user);

    void deleteUserById(Long id);

    User findById(Long id);

    List<User> findAll();

    User updateUserEmailById(Long id, String email);
}
