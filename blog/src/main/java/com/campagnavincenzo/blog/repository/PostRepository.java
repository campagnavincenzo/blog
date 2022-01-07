package com.campagnavincenzo.blog.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.campagnavincenzo.blog.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
	 
	List<Post> findByOwnerId(Long id);
	List<Post> findByPostTitleContaining(String postTitle);
	Post findByIdAndDeleted(Long id, int deleted); // da verificare cosa fa
	List<Post> findByPostDateAfter(Timestamp postDate);
	
	/* @Query */
	@Transactional
	@Modifying
	@Query(value="update post set deleted=1 where id=?",nativeQuery=true)
	int deletedPostById(Long id);
    
	//Questa query fa l'overriding del metodo findById di default
	@Query(value="select * from post where id=? and deleted=0",nativeQuery=true)
	Optional<Post> findById(Long id);
	
	@Query(value="select * from post where deleted=0 order by post_date desc limit 2",nativeQuery=true)
	Optional<List<Post>> getLastTwo();
	
	@Query(value="select * from post where deleted=1",nativeQuery=true)
	Optional<List<Post>> getAllDeleted();
	
	@Query(value="select * from post where post_title=:title",nativeQuery=true)
	public Optional<List<Post>> getPostWithTitle(@Param("title") String title);
}
