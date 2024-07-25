package com.ahmetyeniceri.project_udemy.services.serviceImpl;

import com.ahmetyeniceri.project_udemy.entities.Post;
import com.ahmetyeniceri.project_udemy.enums.PEnum;
import com.ahmetyeniceri.project_udemy.repositories.PostRepository;
import com.ahmetyeniceri.project_udemy.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static com.ahmetyeniceri.project_udemy.enums.PEnum.*;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public ResponseEntity<?> addPost(Post post) {
        HashMap<PEnum, Object> hashMap = new HashMap<>();
        boolean hasTitle = postRepository.existsByTitle(post.getTitle());

        if (hasTitle){
            hashMap.put(status, false);
            hashMap.put(error, "Post title already exists");
            hashMap.put(title, post.getTitle());

            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }

        postRepository.save(post);

        hashMap.put(status, true);
        hashMap.put(result, "Post successfully added");
        hashMap.put(title, post.getTitle());

        return new ResponseEntity<>(hashMap, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deletePost(Long id) {
        HashMap<PEnum, Object> hashMap = new HashMap<>();
        boolean hasPost = postRepository.existsById(id);

        if (hasPost){

            postRepository.deleteById(id);

            hashMap.put(status, true);
            hashMap.put(result, "Post successfully deleted");

            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        }

        hashMap.put(status, false);
        hashMap.put(error, "Post not found with id " + id);

        return new ResponseEntity<>(hashMap, HttpStatus.NOT_FOUND);
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
