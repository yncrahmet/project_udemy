package com.ahmetyeniceri.project_udemy.restControllers;

import com.ahmetyeniceri.project_udemy.entities.User;
import com.ahmetyeniceri.project_udemy.services.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/save")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/find")
    public ResponseEntity<?> findUser(@RequestParam Long id){
        return userService.findUser(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam Long id){
        return userService.deleteUser(id);
    }

}
