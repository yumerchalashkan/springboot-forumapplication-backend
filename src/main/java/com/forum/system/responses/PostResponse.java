package com.forum.system.responses;

import com.forum.system.entity.Like;
import com.forum.system.entity.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResponse {
    Long id;
    Long userId;
    String userName;
    String title;
    String text;
    List<LikeResponse> postLikes;

    public PostResponse(Post post, List<LikeResponse> postLikes) {
        this.id = post.getId();
        this.userId = post.getUser().getId();
        this.userName = post.getUser().getUsername();
        this.title = post.getTitle();
        this.text = post.getText();
        this.postLikes = postLikes;
    }
}
