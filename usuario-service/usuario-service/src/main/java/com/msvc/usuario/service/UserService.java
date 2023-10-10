package com.msvc.usuario.service;

import com.msvc.usuario.entity.User;

import java.util.List;

public interface UserService {

    User saveUser (User user);

    List<User> getAllUsers();

    User getUser(Long userId);
}
