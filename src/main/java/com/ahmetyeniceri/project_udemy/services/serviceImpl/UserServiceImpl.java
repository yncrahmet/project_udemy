package com.ahmetyeniceri.project_udemy.services.serviceImpl;

import com.ahmetyeniceri.project_udemy.entities.User;
import com.ahmetyeniceri.project_udemy.repositories.UserRepository;
import com.ahmetyeniceri.project_udemy.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> addUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>("Created user:", HttpStatusCode.valueOf(404));
    }

    @Override
    public ResponseEntity<?> findUser(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteUser(Long id) {
        return null;
    }
}
