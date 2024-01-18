package com.example.entity.common;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

/**
 * 기본 등록/수정(날짜) 엔티티
 *
 * @author LEESEMIN
 */
@Getter
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public class BaseDtEntity {

	@CreatedDate
	@Column(name = "CREATE_DT", columnDefinition = "DATETIME", nullable = false, updatable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	@Comment("생성일자")
	private LocalDateTime createDt;

	@LastModifiedDate
	@Column(name = "MODIFY_DT", columnDefinition = "DATETIME", nullable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	@Comment("수정일자")
	private LocalDateTime modifyDt;
}