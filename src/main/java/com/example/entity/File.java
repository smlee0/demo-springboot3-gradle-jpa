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

/**
 * 파일 엔티티
 *
 * @author LEESEMIN
 */
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file")
public class File extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Comment("파일 ID")
	private Long id;

	@Column(name = "img_upload_path")
	@Comment("이미지 업로드 경로")
	private String imgUploadPath;

	@Column(name = "img_origin_name")
	@Comment("이미지 원본 파일 명")
	private String imgOriginName;

	@Column(name = "extension")
	@Comment("타입")
	private String type;

	@Column(name = "size")
	@Comment("파일크기")
	private String size;

	// @JsonIgnore
	// @OneToOne(mappedBy = "file")
	// private BoardFile boardFile;
	//
	// @JsonIgnore
	// @OneToOne(mappedBy = "file")
	// private Board2File board2File;

}