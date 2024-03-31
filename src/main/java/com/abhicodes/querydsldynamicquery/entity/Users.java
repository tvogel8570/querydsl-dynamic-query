package com.abhicodes.querydsldynamicquery.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "abhi_users")
@Data
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native")
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "full_name")
	private String fullName;

}
