package com.ahmetyeniceri.project_udemy.repositories;

import com.ahmetyeniceri.project_udemy.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    boolean existsByTitle(String title);

}
