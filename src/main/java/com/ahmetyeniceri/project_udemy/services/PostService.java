package com.ahmetyeniceri.project_udemy.services;

import com.ahmetyeniceri.project_udemy.entities.Post;
import com.ahmetyeniceri.project_udemy.enums.PEnum;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface PostService {

    ResponseEntity<Map<PEnum, Object>> addPost(Post post);

    ResponseEntity<Map<PEnum, Object>> deletePost(Long id);

    ResponseEntity<Map<PEnum, Object>> updatePost(Post post);

    ResponseEntity<Map<PEnum, Object>> findPostById(Long id);

    ResponseEntity<Map<PEnum, Object>> findPostAll();
}
