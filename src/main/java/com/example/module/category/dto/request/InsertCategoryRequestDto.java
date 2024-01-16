package com.example.module.category.dto.request;

import com.example.entity.Category;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 카테고리 등록 > 요청 DTO
 *
 * @author LEESEMIN
 */
@Getter
@Setter
@Builder
public class InsertCategoryRequestDto {
	@NotBlank(message = "카테고리 명을 입력해 주세요.")
	private String name;
	@NotBlank(message = "카테고리 코드를 입력해 주세요.")
	private String code;

	/**
	 * DTO -> Entity 변환
	 *
	 * @return
	 */
	public Category toEntity() {
		return Category.builder()
			.name(this.name)
			.code(this.code)
			.build();
	}

}
