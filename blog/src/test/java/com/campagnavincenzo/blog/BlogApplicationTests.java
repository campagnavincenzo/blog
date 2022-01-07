package com.campagnavincenzo.blog;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

import com.campagnavincenzo.blog.entity.Post;
import com.campagnavincenzo.blog.repository.CommentRepository;
import com.campagnavincenzo.blog.repository.PostRepository;
//import com.campagnavincenzo.blog.BlogApplicationTests.TestConfig;

import lombok.extern.slf4j.Slf4j;
@SpringBootTest
//@DataJpaTest
//@PropertySource(value = {"classpath:application.properties"})
@Slf4j
class BlogApplicationTests {
	@Autowired
    private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	
	

		@Test
	    public void contextLoads() {
	    	assertThat(postRepository).isNotNull();
	    	//assertThat(commentRepository).isNotNull();
	    }
		
		@Test
	    public void findPost() {
	        log.info("Trovo il post con il body=post di test");
	        Post postTemp=new Post();
	        Optional<List<Post>> post = postRepository.getPostWithTitle("title di test");
            
	        if (post !=null) {
	          log.info("Il post con ID=1 è : "+post.toString());
	          assertThat("body di test").isEqualTo(post.isPresent()?post.get().get(0).getBody():postTemp);
	        }  
	    }
	    
		@BeforeEach
	    public void setup() {
	        Post post1 = new Post();
	        post1.setBody("body di test");
	        post1.setPostTitle("title di test");
	        post1.setDeleted(0);
	       

	        postRepository.save(post1);
	        
	    }
        
//		@Configuration
//	    @EnableJpaRepositories(basePackageClasses = PostRepository.class)
//	    @EntityScan(basePackageClasses = Post.class)
//		@PropertySource("classpath:application.properties") 
//	    static class TestConfig {
//
//	    }

}
