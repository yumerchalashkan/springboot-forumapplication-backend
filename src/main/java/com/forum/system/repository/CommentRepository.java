package com.forum.system.repository;

import com.forum.system.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByUserIdAndPostId(Long aLong, Long aLong1);

    List<Comment> findByUserId(Long userId);

    List<Comment> findByPostId(Long aLong);
}

