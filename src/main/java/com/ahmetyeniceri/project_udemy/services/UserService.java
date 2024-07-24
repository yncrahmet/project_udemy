package com.ahmetyeniceri.project_udemy.services;

import com.ahmetyeniceri.project_udemy.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<?> addUser(User user);
    public ResponseEntity<?> findUser(Long id);
    public ResponseEntity<?> deleteUser(Long id);
    public ResponseEntity<?> updateUser(User user);
}
