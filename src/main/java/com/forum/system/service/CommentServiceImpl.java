package com.forum.system.service;

import com.forum.system.entity.Comment;
import com.forum.system.entity.Post;
import com.forum.system.entity.User;
import com.forum.system.repository.CommentRepository;
import com.forum.system.requests.CommentCreateRequest;
import com.forum.system.requests.CommentUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;

    @Override
    public List<Comment> findAll(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent() && postId.isPresent()){
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }else if(userId.isPresent()){
            return commentRepository.findByUserId(userId.get());
        }else if(postId.isPresent()){
            return commentRepository.findByPostId(postId.get());
        }else {
            return commentRepository.findAll();
        }

    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment save(CommentCreateRequest commentCreateRequest) {
        User user = userService.findById(commentCreateRequest.getUserId());
        Post post = postService.findById(commentCreateRequest.getPostId());

        if(user != null && post != null){
            Comment comment = new Comment();
            comment.setId(commentCreateRequest.getId());
            comment.setPost(post);
            comment.setUser(user);
            comment.setText(commentCreateRequest.getText());
            return commentRepository.save(comment);
        }else {
            return null;
        }

    }

    @Override
    public Comment updateComment(Long id, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()) {
            Comment commentUpdate = comment.get();
            commentUpdate.setText(commentUpdateRequest.getText());
            return commentRepository.save(commentUpdate);
        }else {
            return null;
        }
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}

