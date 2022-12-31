package com.forum.system.service;

import com.forum.system.entity.Like;
import com.forum.system.entity.Post;
import com.forum.system.entity.User;
import com.forum.system.repository.PostRepository;
import com.forum.system.requests.PostCreateRequest;
import com.forum.system.requests.PostUpdateRequest;
import com.forum.system.responses.LikeResponse;
import com.forum.system.responses.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;


    private LikeService likeService;

    @Autowired
    public void setLikeService(LikeService likeService) {
        this.likeService = likeService;
    }





    @Override
    public List<PostResponse> findAll(Optional<Long> id) {
        List<Post> list;
        if(id.isPresent()) {
            list = postRepository.findByUserId(id.get());
        }else {
            list = postRepository.findAll();
        }

        return list.stream().map(post -> {
            List<LikeResponse> likes = likeService.getAllLikesWithParam(Optional.ofNullable(null), Optional.of(post.getId()));
            return new PostResponse(post, likes);}).collect(Collectors.toList());

    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow();
    }

    @Override
    public Post save(PostCreateRequest postCreateRequest) {
        User user = userService.findById(postCreateRequest.getUserId());
        if(user == null) {
            return null;
        }
        Post post = new Post();
        post.setId(postCreateRequest.getId());
        post.setTitle(postCreateRequest.getTitle());
        post.setText(postCreateRequest.getText());
        post.setUser(user);
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, PostUpdateRequest post) {
        Optional<Post> postOptional = postRepository.findById(id);
        if(postOptional.isPresent()) {
            Post postUpdate = postOptional.get();
            postUpdate.setTitle(post.getTitle());
            postUpdate.setText(post.getText());
            return postRepository.save(postUpdate);
        }
        return null;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}

