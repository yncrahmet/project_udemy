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
import java.util.List;
import java.util.Optional;

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
        boolean hasTitle = postRepository.existsById(id);

        if (hasTitle){

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
        HashMap<PEnum, Object> hashMap = new HashMap<>();
        Optional<Post> optionalPost = postRepository.findById(post.getId());

        if (optionalPost.isPresent()) {
            postRepository.saveAndFlush(post);

            hashMap.put(status, true);
            hashMap.put(result, "Post successfully updated");
            hashMap.put(title, post.getTitle());

            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        }

        hashMap.put(status, false);
        hashMap.put(error, "Post not found with id " + post.getId());

        return new ResponseEntity<>(hashMap, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> findPostById(Long id) {
        HashMap<PEnum, Object> hashMap = new HashMap<>();
        Post post = postRepository.findById(id).orElse(null);

        if (post != null){
            hashMap.put(status, true);
            hashMap.put(result, post);

            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        }

        hashMap.put(status, false);
        hashMap.put(error, "Post not found with id " + id);

        return new ResponseEntity<>(hashMap, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Post> findPostAll() {
        return postRepository.findAll();
    }
}
