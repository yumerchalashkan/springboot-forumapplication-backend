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

		User user2 = new User();
		user2.setUsername("demo");
		user2.setPassword(passwordEncoder.encode("demo"));
		userService.save(user2);

		Post post = new Post();
		post.setTitle("What is Spring Boot?");
		post.setText("Spring Boot is a popular Java-based framework that is used to build web applications and microservices. It is built on top of the Spring Framework and provides a simplified way to configure and set up a Spring application. With Spring Boot, developers can quickly create stand-alone, production-ready applications by providing a set of default configurations for common application needs such as embedding a web server, connecting to a database, configuring security settings, and setting up logging. Spring Boot also makes it easy to customize the configuration of an application by providing options such as using properties files, command-line arguments, and environment variables. Additionally, Spring Boot offers a number of \"Starters\" which are pre-configured dependencies that you can include in your project to add functionality quickly. Overall, Spring Boot simplifies the development process by taking care of the boilerplate configuration and providing a wide range of features out of the box.");
		post.setUser(user);

		PostCreateRequest postCreateRequest = new PostCreateRequest();
		postCreateRequest.setTitle("What is Spring Boot?");
		postCreateRequest.setText("Spring Boot is a popular Java-based framework that is used to build web applications and microservices. It is built on top of the Spring Framework and provides a simplified way to configure and set up a Spring application. With Spring Boot, developers can quickly create stand-alone, production-ready applications by providing a set of default configurations for common application needs such as embedding a web server, connecting to a database, configuring security settings, and setting up logging. Spring Boot also makes it easy to customize the configuration of an application by providing options such as using properties files, command-line arguments, and environment variables. Additionally, Spring Boot offers a number of \"Starters\" which are pre-configured dependencies that you can include in your project to add functionality quickly. Overall, Spring Boot simplifies the development process by taking care of the boilerplate configuration and providing a wide range of features out of the box.");
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
