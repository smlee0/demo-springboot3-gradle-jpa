package com.example.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;

import com.example.entity.common.BaseEntity;
import com.example.library.constant.AccountRoleType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 계정 엔티티
 *
 * @author LEESEMIN
 */
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account", indexes = @Index(columnList = "email"))
public class Account extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Comment("유저ID")
	private Long id;

	@Column(nullable = false)
	@Comment("유저명")
	private String username;

	@Column(nullable = false)
	@Comment("닉네임")
	private String nickname;

	@Column(nullable = false)
	@Comment("이메일")
	private String email;

	@Column(nullable = false)
	@Comment("휴대폰번호")
	private String phone;

	@Column(nullable = false)
	@Comment("비밀번호")
	private String password;

	@Column(name = "password_modify_dt")
	@Comment("비밀번호 변경 일자")
	private LocalDateTime passwordModifyDt;

	@Column(name = "password_expired_dt")
	@Comment("비밀번호 만료 일자")
	private LocalDateTime passwordExpiredDt;

	@Column(name = "account_role")
	@Comment("유저 권한")
	@Enumerated(EnumType.STRING)
	private AccountRoleType accountRole;

	@Column(name = "delete_dt")
	@Comment("탈퇴처리일자")
	private LocalDateTime deleteDt;

}
