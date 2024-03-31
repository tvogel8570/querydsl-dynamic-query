package com.abhicodes.querydsldynamicquery.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "abhi_post_types")
@Data
public class PostType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native")
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "type")
	private String type;

}
