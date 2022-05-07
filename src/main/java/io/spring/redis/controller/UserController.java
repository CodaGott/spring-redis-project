package io.spring.redis.controller;

import io.spring.redis.model.User;
import io.spring.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String > saveUser(@RequestBody User user){
        boolean result = userService.saveUser(user);
        if (result){
            return ResponseEntity.ok("User created successfully");
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users;

        users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getAUser(@PathVariable Long id){
        User user;
        user = userService.getAUser(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        boolean result = userService.deleteUserById(id);
        if (result){
            return ResponseEntity.ok("User deleted successfully");
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user){
        boolean result = userService.updateUserById(user, id);
        if (result){
            return ResponseEntity.ok("User updated successfully");
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
}
