package com.example.module.category.dto;

import com.example.entity.Category;

import lombok.Builder;
import lombok.Data;

/**
 * 카테고리 요청 DTO
 *
 * @author LEESEMIN
 */
@Data
@Builder
public class CategoryRequestDto {
	private Long id;
	private String name;
	private String code;
	private int sortNo;

	/**
	 * DTO -> Entity 변환
	 *
	 * @return
	 */
	public Category toEntity() {
		return Category.builder()
			.id(id)
			.name(name)
			.code(code)
			.sortNo(sortNo)
			.build();
	}

	/**
	 * Entity -> DTO 변환
	 *
	 * @param category
	 * @return
	 */
	public CategoryRequestDto toDto(Category category) {
		return CategoryRequestDto.builder()
			.id(category.getId())
			.name(category.getName())
			.code(category.getCode())
			.sortNo(category.getSortNo())
			.build();
	}

}
