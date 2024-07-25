package com.ahmetyeniceri.project_udemy.restControllers;

import com.ahmetyeniceri.project_udemy.entities.Post;
import com.ahmetyeniceri.project_udemy.enums.PEnum;
import com.ahmetyeniceri.project_udemy.services.serviceImpl.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {
    private final PostServiceImpl postService;

    @PostMapping("/save")
    public ResponseEntity<Map<PEnum, Object>> addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<PEnum, Object>> deletePost(@RequestParam Long id) {
        return postService.deletePost(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Map<PEnum, Object>> updatePost(@RequestBody Post post) {
        return postService.updatePost(post);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Map<PEnum, Object>> findPostById(@PathVariable Long id) {
        return postService.findPostById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<Map<PEnum, Object>> findPostAll() {
        return postService.findPostAll();
    }

}
