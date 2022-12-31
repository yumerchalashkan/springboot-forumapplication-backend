package com.forum.system.service;

import com.forum.system.entity.Post;
import com.forum.system.requests.PostCreateRequest;
import com.forum.system.requests.PostUpdateRequest;
import com.forum.system.responses.PostResponse;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostResponse> findAll(Optional<Long> id);
    Post findById(Long id);
    Post save(PostCreateRequest post);
    Post updatePost(Long id, PostUpdateRequest postUpdateRequestt);
    void deletePost(Long id);
}
