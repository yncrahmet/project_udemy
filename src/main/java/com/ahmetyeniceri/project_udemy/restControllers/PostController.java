package com.ahmetyeniceri.project_udemy.restControllers;

import com.ahmetyeniceri.project_udemy.entities.Post;
import com.ahmetyeniceri.project_udemy.services.serviceImpl.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {
    private final PostServiceImpl postService;

    @PostMapping("/save")
    public ResponseEntity<?> addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePost(@RequestParam Long id) {
        return postService.deletePost(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePost(@RequestBody Post post) {
        return postService.updatePost(post);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findPostById(@PathVariable Long id) {
        return postService.findPostById(id);
    }

    @GetMapping("/all")
    public List<Post> findPostAll() {
        return postService.findPostAll();
    }

}
