package com.campagnavincenzo.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campagnavincenzo.blog.entity.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
