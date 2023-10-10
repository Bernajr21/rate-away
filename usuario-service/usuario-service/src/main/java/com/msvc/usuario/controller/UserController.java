package com.msvc.usuario.controller;

import com.msvc.usuario.entity.User;
import com.msvc.usuario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User userRequest){
        User user = userService.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id){
        User user = userService.getUser(Long.valueOf(id));
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity <List<User>> getAllUsers(){
        List <User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }
}
