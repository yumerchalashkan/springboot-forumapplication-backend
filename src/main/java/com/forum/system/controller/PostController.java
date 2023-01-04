package com.forum.system.controller;

import com.forum.system.entity.Post;
import com.forum.system.requests.PostCreateRequest;
import com.forum.system.requests.PostUpdateRequest;
import com.forum.system.responses.PostResponse;
import com.forum.system.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostResponse>> findAll(@RequestParam Optional<Long> id) {
        return ResponseEntity.ok(postService.findAll(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody PostCreateRequest postCreateRequest) {
        return ResponseEntity.ok(postService.save(postCreateRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequest postUpdateRequest) {
        return ResponseEntity.ok(postService.updatePost(id, postUpdateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }

}
