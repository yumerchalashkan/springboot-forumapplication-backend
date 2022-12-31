package com.forum.system.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {
    Long id;
    String text;
    Long userId;
    Long postId;
}

