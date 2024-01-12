package com.example.module.category.dto.response;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import com.example.entity.Category;

import lombok.Builder;
import lombok.Data;

/**
 * 카테고리 응답 DTO
 *
 * @author LEESEMIN
 */
@Data
@Builder
public class CategoryResponseDto {

	private static ModelMapper modelMapper = new ModelMapper();

	private Long id;
	private String name;
	private String code;
	private Integer sortNo;

	/**
	 * Entity -> DTO 변환
	 *
	 * @param category
	 * @return
	 */
	// public CategoryRequestDto toDto(Category category) {
	// 	return CategoryRequestDto.builder()
	// 		.id(category.getId())
	// 		.name(category.getName())
	// 		.code(category.getCode())
	// 		.sortNo(category.getSortNo())
	// 		.build();
	// }

	/**
	 * Entity -> DTO 변환
	 *
	 * @param category
	 * @return
	 */
	public static CategoryResponseDto of(Category category) {
		return modelMapper.map(category, CategoryResponseDto.class);
	}

	/**
	 * Entity -> DTO 변환 (Page의 경우)
	 *
	 * @param sourcePage
	 * @return
	 */
	public static Page<CategoryResponseDto> of(Page<Category> sourcePage) {
		return sourcePage.map(CategoryResponseDto::of);
	}
}
