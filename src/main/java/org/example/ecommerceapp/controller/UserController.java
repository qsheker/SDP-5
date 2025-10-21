package org.example.ecommerceapp.controller;

import org.example.ecommerceapp.models.User;
import org.example.ecommerceapp.service.UserService;
import org.example.ecommerceapp.web.dto.user.UserRequestDto;
import org.example.ecommerceapp.web.dto.user.UserResponseDto;
import org.example.ecommerceapp.web.mappers.user.UserRequestMapper;
import org.example.ecommerceapp.web.mappers.user.UserResponseMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    public UserController(UserService userService, UserRequestMapper userRequestMapper, UserResponseMapper userResponseMapper) {
        this.userService = userService;
        this.userRequestMapper = userRequestMapper;
        this.userResponseMapper = userResponseMapper;
    }

    @GetMapping
    List<User> getAll(){
        return userService.findAll();
    }

    @PutMapping("/save")
    public void save(@RequestBody UserRequestDto user){
        User entity = userRequestMapper.toEntity(user);
        userService.save(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }

    @GetMapping("{id}")
    public User findUserById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @PostMapping
    public UserResponseDto updateUser(@RequestBody UserRequestDto user){
        User entity = userRequestMapper.toEntity(user);
        var updated = userResponseMapper.toDto(userService.update(entity));
        return updated;
    }

    @PatchMapping("/{id}/{email}")
    public UserRequestDto updateUserEmail(@PathVariable Long id, @PathVariable String email){
        return userRequestMapper.toDto(userService.updateUserEmailById(id,email));
    }


}
