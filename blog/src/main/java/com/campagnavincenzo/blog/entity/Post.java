package com.campagnavincenzo.blog.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Table(name = "post")
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@Column(name = "post_title")
    private String postTitle;
    private String body;
    @Column(name = "post_date")
    private Timestamp postDate;
    private int deleted; // Se deleted è zero il post vuol dire che è attivo, se è uno vuol dire invece che è cancellato.
    @Column(name="owner_id")
    private long ownerId; // L'ownerId rappresenta chi ha scritto il post
    @Column(name="comment_id",nullable=true)
    private String commentId; // commentId rappresenta l'ID dei commenti relativi

}
