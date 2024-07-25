package com.ahmetyeniceri.project_udemy.services.serviceImpl;

import com.ahmetyeniceri.project_udemy.entities.Post;
import com.ahmetyeniceri.project_udemy.enums.PEnum;
import com.ahmetyeniceri.project_udemy.repositories.PostRepository;
import com.ahmetyeniceri.project_udemy.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.ahmetyeniceri.project_udemy.enums.PEnum.*;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public ResponseEntity<Map<PEnum, Object>> addPost(Post post) {
        HashMap<PEnum, Object> hashMap = new HashMap<>();

        try {
            postRepository.save(post);

            hashMap.put(status, true);
            hashMap.put(messages, "Post successfully added!");
            hashMap.put(result, post);

            return new ResponseEntity<>(hashMap, HttpStatus.CREATED);

        } catch (Exception ex) {
            hashMap.put(status, false);
            hashMap.put(error, "Post is not add!");
            hashMap.put(result, post);

            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Map<PEnum, Object>> deletePost(Long id) {
        HashMap<PEnum, Object> hashMap = new HashMap<>();
        boolean hasPost = postRepository.existsById(id);

        if (hasPost) {

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
    public ResponseEntity<Map<PEnum, Object>> updatePost(Post post) {
        HashMap<PEnum, Object> hashMap = new HashMap<>();
        Optional<Post> optionalPost = postRepository.findById(post.getId());

        if (optionalPost.isPresent()) {
            postRepository.saveAndFlush(post);

            hashMap.put(status, true);
            hashMap.put(messages, "Post is successfully updated");
            hashMap.put(result, post);

            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        }

        hashMap.put(status, false);
        hashMap.put(error, "Post is not found with id " + post.getId());

        return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Map<PEnum, Object>> findPostById(Long id) {
        HashMap<PEnum, Object> hashMap = new HashMap<>();
        Post post = postRepository.findById(id).orElse(null);

        if (post != null) {
            hashMap.put(status, true);
            hashMap.put(result, post);

            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        }

        hashMap.put(status, false);
        hashMap.put(error, "Post not found with id " + id);

        return new ResponseEntity<>(hashMap, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Map<PEnum, Object>> findPostAll() {
        HashMap<PEnum, Object> hashMap = new HashMap<>();

        try {
            hashMap.put(status, true);
            hashMap.put(messages, "List of the posts");
            hashMap.put(result, postRepository.findAll());

            return new ResponseEntity<>(hashMap, HttpStatus.OK);

        } catch (Exception ex) {
            hashMap.put(status, false);
            hashMap.put(error, "Error!");

            return new ResponseEntity<>(hashMap, HttpStatus.NOT_FOUND);
        }
    }
}
