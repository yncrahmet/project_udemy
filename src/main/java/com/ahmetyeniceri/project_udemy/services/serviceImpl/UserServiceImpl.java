package com.ahmetyeniceri.project_udemy.services.serviceImpl;

import com.ahmetyeniceri.project_udemy.entities.User;
import com.ahmetyeniceri.project_udemy.enums.PEnum;
import com.ahmetyeniceri.project_udemy.repositories.UserRepository;
import com.ahmetyeniceri.project_udemy.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static com.ahmetyeniceri.project_udemy.enums.PEnum.*;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> addUser(User user) {
        HashMap<PEnum,Object> hashMap = new HashMap<>();
        boolean hasUserName = userRepository.existsByUserName(user.getUserName());

        if (hasUserName) {
            hashMap.put(status,false);
            hashMap.put(messages,"Already exist user");
            hashMap.put(username,user.getUserName());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }
        userRepository.save(user);
        hashMap.put(status,true);
        hashMap.put(messages,"User created");
        hashMap.put(username,user.getUserName());
        return new ResponseEntity<>(hashMap,HttpStatus.CREATED);
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
