package com.forum.system.service;

import com.forum.system.entity.Comment;
import com.forum.system.requests.CommentCreateRequest;
import com.forum.system.requests.CommentUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> findAll(Optional<Long> userId, Optional<Long> postId);
    Comment findById(Long id);

    Comment save(CommentCreateRequest commentCreateRequest);
    Comment updateComment(Long id, CommentUpdateRequest commentUpdateRequest);
    void deleteComment(Long id);
}
