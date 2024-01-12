package com.example.entity.common;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

/**
 * 기본 Entity
 */
@Getter
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public class BaseEntity {

	@CreatedDate
	@Column(name = "CREATE_DT", columnDefinition = "DATETIME", nullable = false, updatable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	@Comment("생성일자")
	private LocalDateTime createDt;

	@CreatedBy
	@Column(name = "CREATE_ID", updatable = false)
	@Comment("생성자")
	private Long createId;

	@LastModifiedDate
	@Column(name = "MODIFY_DT", columnDefinition = "DATETIME", nullable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	@Comment("수정일자")
	private LocalDateTime modifyDt;

	@LastModifiedBy
	@Column(name = "MODIFY_ID")
	@Comment("수정자")
	private Long modifyId;

}
