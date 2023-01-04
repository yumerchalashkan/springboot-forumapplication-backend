package com.forum.system;

import com.forum.system.entity.Comment;
import com.forum.system.entity.Post;
import com.forum.system.entity.User;
import com.forum.system.requests.CommentCreateRequest;
import com.forum.system.requests.PostCreateRequest;
import com.forum.system.service.CommentService;
import com.forum.system.service.PostService;
import com.forum.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SystemApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {

		SpringApplication.run(SystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("admin");
		user.setPassword(passwordEncoder.encode("admin"));
		userService.save(user);

		Post post = new Post();
		post.setTitle("title");
		post.setText("text");
		post.setUser(user);

		PostCreateRequest postCreateRequest = new PostCreateRequest();
		postCreateRequest.setTitle("title");
		postCreateRequest.setText("text");
		postCreateRequest.setUserId(user.getId());
		postService.save(postCreateRequest);


		CommentCreateRequest commentCreateRequest = new CommentCreateRequest();
		commentCreateRequest.setId(10L);
		commentCreateRequest.setText("text");
		commentCreateRequest.setUserId(1L);
		commentCreateRequest.setPostId(1L);
		commentService.save(commentCreateRequest);


	}
}
