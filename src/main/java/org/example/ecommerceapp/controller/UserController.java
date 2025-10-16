package org.example.ecommerceapp.controller;

import org.example.ecommerceapp.models.User;
import org.example.ecommerceapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<User> getAll(){
        return userService.findAll();
    }

    @PutMapping("/save")
    public void save(@RequestBody User user){
        userService.save(user);
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
    public User updateUser(@RequestBody User user){
        return userService.update(user);
    }
    @PatchMapping("/{id}/{email}")
    public User updateUserEmail(@PathVariable Long id, @PathVariable String email){
        return userService.updateUserEmailById(id,email);
    }


}
