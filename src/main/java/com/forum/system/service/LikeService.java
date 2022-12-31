package com.forum.system.service;

import com.forum.system.entity.Like;
import com.forum.system.requests.LikeCreateRequest;
import com.forum.system.responses.LikeResponse;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<LikeResponse> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId);
    Like createOneLike(LikeCreateRequest request);
    Like getOneLikeById(Long likeId);
    void deleteOneLikeById(Long likeId);

}
