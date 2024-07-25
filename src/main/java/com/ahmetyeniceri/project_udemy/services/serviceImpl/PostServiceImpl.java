package com.ahmetyeniceri.project_udemy.services.serviceImpl;

import com.ahmetyeniceri.project_udemy.entities.Post;
import com.ahmetyeniceri.project_udemy.repositories.PostRepository;
import com.ahmetyeniceri.project_udemy.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public ResponseEntity<?> addPost(Post post) {
        return null;
    }

    @Override
    public ResponseEntity<?> deletePost(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> updatePost(Post post) {
        return null;
    }

    @Override
    public ResponseEntity<?> findPostById(Long id) {
        return null;
    }
}
