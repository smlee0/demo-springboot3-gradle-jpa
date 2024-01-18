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

// @Data
// @Entity
// @SuperBuilder
// @NoArgsConstructor
// @AllArgsConstructor
// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // JPA에서 lazy관련 에러 날 경우 사용
// @DynamicInsert
// @DynamicUpdate

/**
 * 샘플 엔티티 (테스트 및 참고용)
 *
 * @author LEESEMIN
 */
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sample")
public class Sample extends BaseEntity {

	//	@GeneratedValue(generator="system-uuid")
	//	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	@Comment("샘플 ID")
	private Long id;

	@Column(name = "code", nullable = false)
	@Comment("제목")
	private String title;

	@Column(name = "name", nullable = false)
	@Comment("내용")
	private String contents;

	@Column(name = "thumb_img_upload_path")
	@Comment("썸네일 이미지 업로드 경로")
	private String thumbImgUploadPath;

	@Column(name = "thumb_img_origin_name")
	@Comment("썸네일 이미지 원본 파일 명")
	private String thumbImgOriginName;

	@Column(name = "thumb_img_alt_text")
	@Comment("썸네일 이미지 대체 텍스트")
	private String thumbImgAltText;

	// @JsonBackReference
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "common_id", insertable = false, updatable = false)
	// @Comment("공통코드 ID")
	// private CommonCode commonCode;

	// 공통코드 연결 시
	// @JsonIgnore
	// @JsonManagedReference
	// @OneToMany(mappedBy = "commonCode")
	// private List<Sample> categories;

}