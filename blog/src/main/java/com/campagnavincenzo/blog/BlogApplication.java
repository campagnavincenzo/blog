package com.campagnavincenzo.blog;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.campagnavincenzo.blog.entity.Comment;
import com.campagnavincenzo.blog.entity.Post;
import com.campagnavincenzo.blog.repository.CommentRepository;
import com.campagnavincenzo.blog.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@EnableJpaRepositories("com.campagnavincenzo.blog.repository")
@SpringBootApplication
public class BlogApplication implements CommandLineRunner{
    @Autowired
	private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    
	public static void main(String[] args) {
//    	NOTA BENE: JPA ha una sessione delle entità che facciamo
		SpringApplication.run(BlogApplication.class, args);
    	
		
	}
	
	public void run(String... args) throws Exception  {
		Post primo = new Post();
		primo.setPostTitle("Primo post");
		primo.setBody("Primo body");
		primo.setOwnerId(111);
		primo.setPostDate(new Timestamp(Instant.now().toEpochMilli()));
		primo.setDeleted(0);
		log.info("Insert result 1 ::::{}",postRepository.save(primo).getId());
		
		Post secondo =new Post();
		secondo.setPostTitle("Secondo post");
		secondo.setBody("Secondo body");
		secondo.setPostDate(new Timestamp(Instant.now().toEpochMilli()));
		secondo.setDeleted(0);
		log.info("Insert result 2 ::::{}",postRepository.save(secondo).getId());
		
		Post terzo =new Post();
		terzo.setPostTitle("Terzo post");
		terzo.setBody("Terzo body");
		terzo.setPostDate(new Timestamp(Instant.now().toEpochMilli()));
		terzo.setDeleted(0);
		log.info("Insert result 3 ::::{}",postRepository.save(terzo).getId());
		
		Comment comment=new Comment();
		comment.setBody("Primo comment");
		comment.setCommenterId((long) 222);
		log.info("Insert first comment :::: ", commentRepository.save(comment).getId());
	}
    
}
