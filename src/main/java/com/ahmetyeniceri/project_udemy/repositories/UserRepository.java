package com.ahmetyeniceri.project_udemy.repositories;

import com.ahmetyeniceri.project_udemy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserName(String userName);

}