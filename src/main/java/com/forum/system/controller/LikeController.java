package com.forum.system.controller;

import com.forum.system.entity.Like;
import com.forum.system.requests.LikeCreateRequest;
import com.forum.system.responses.LikeResponse;
import com.forum.system.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/like")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LikeController {
    private final LikeService likeService;

    @GetMapping
    public List<LikeResponse> getAllLikes(@RequestParam Optional<Long> userId,
                                          @RequestParam Optional<Long> postId) {
        return likeService.getAllLikesWithParam(userId, postId);
    }

    @PostMapping
    public Like createOneLike(@RequestBody LikeCreateRequest request) {
        return likeService.createOneLike(request);
    }

    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Long likeId) {
        return likeService.getOneLikeById(likeId);
    }

    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId) {
        likeService.deleteOneLikeById(likeId);
    }
}
