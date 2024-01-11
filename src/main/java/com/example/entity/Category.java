package com.example.entity;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@DynamicInsert
@DynamicUpdate
@Table(name = "CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	@Comment("카테고리 ID")
	private Long id;

	// @JsonBackReference
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "common_id", insertable = false, updatable = false)
	// @Comment("공통코드 ID")
	// private CommonCode commonCode;

	// 공통코드 연결 시
	// @JsonIgnore
	// @JsonManagedReference
	// @OneToMany(mappedBy = "commonCode")
	// private List<Category> categories;

	@Column(name = "code", nullable = false)
	@Comment("카테고리코드")
	private String code;

	@Column(name = "name", nullable = false)
	@Comment("카테고리명")
	private String name;

	@Column(name = "sort_no")
	@Comment("우선노출순번")
	private int sortNo;

}