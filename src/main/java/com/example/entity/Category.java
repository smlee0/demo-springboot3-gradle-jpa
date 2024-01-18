package com.example.entity;

import org.hibernate.annotations.Comment;

import com.example.entity.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	@Comment("카테고리 ID")
	private Long id;

	@Column(name = "code", nullable = false)
	@Comment("카테고리코드")
	private String code;

	@Column(name = "name", nullable = false)
	@Comment("카테고리명")
	private String name;

	@Column(name = "sort_no")
	@Comment("우선노출순번")
	private Integer sortNo;

}