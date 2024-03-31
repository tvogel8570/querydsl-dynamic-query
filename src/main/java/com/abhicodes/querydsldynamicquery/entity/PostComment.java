package com.abhicodes.querydsldynamicquery.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "abhi_post_comments")
@Data
public class PostComment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String comments;

	@ManyToOne(fetch = FetchType.LAZY)
	private Post post;

}
