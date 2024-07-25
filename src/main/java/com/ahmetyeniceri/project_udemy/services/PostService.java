package com.ahmetyeniceri.project_udemy.services;

import com.ahmetyeniceri.project_udemy.entities.Post;
import org.springframework.http.ResponseEntity;

public interface PostService {

    ResponseEntity<?> addPost(Post post);
    ResponseEntity<?> deletePost(Long id);
    ResponseEntity<?> updatePost(Post post);
    ResponseEntity<?> findPostById(Long id);
}
