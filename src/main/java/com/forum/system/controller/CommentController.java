package com.forum.system.controller;

import com.forum.system.entity.Comment;
import com.forum.system.requests.CommentCreateRequest;
import com.forum.system.requests.CommentUpdateRequest;
import com.forum.system.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        return ResponseEntity.ok(commentService.findAll(userId, postId));
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long commentId) {
        return ResponseEntity.ok(commentService.findById(commentId));
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CommentCreateRequest commentCreateRequest) {
        return ResponseEntity.ok(commentService.save(commentCreateRequest));
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest commentUpdateRequest) {
        return ResponseEntity.ok(commentService.updateComment(commentId, commentUpdateRequest));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }

}
