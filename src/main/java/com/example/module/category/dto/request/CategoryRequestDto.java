package com.example.module.category.dto.request;

import com.example.entity.Category;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 카테고리 요청 DTO
 *
 * @author LEESEMIN
 */
@Getter
@Setter
@Builder
public class CategoryRequestDto {
	private Long id;
	private String name;
	private String code;

	/**
	 * DTO -> Entity 변환
	 *
	 * @return
	 */
	public Category toEntity() {
		return Category.builder()
			.id(this.id)
			.name(this.name)
			.code(this.code)
			.build();
	}

}
