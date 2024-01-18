package com.example.entity.common;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

/**
 * 기본 등록/수정 엔티티
 *
 * @author LEESEMIN
 */
@Getter
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public class BaseEntity extends BaseDtEntity {

	@CreatedBy
	@Column(name = "CREATE_ID", updatable = false)
	@Comment("생성자")
	private Long createId;
	@LastModifiedBy
	@Column(name = "MODIFY_ID")
	@Comment("수정자")
	private Long modifyId;

}
