package com.campagnavincenzo.blog.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private String body;
    @Column(name="commenter_id")
    private Long commenterId; // Il commenterId rappresenta chi ha fatto il commento
    @Column(name="comment_date")
    private Timestamp commentDate;
    private int deleted;
}
