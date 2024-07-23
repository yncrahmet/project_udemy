package com.ahmetyeniceri.project_udemy.services;

import com.ahmetyeniceri.project_udemy.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> addUser(User user);
    ResponseEntity<?> findUser(Long id);
    ResponseEntity<?> deleteUser(Long id);
}
