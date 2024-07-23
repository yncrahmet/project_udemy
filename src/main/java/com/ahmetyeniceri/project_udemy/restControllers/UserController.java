package com.ahmetyeniceri.project_udemy.restControllers;

import com.ahmetyeniceri.project_udemy.entities.User;
import com.ahmetyeniceri.project_udemy.services.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/save")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
