package com.example.module.category.dto.response;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import com.example.entity.Category;
import com.example.library.common.CommonFilter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 카테고리 응답 DTO
 *
 * @author LEESEMIN
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class CategoryResponseDto extends CommonFilter {

	private static ModelMapper modelMapper = new ModelMapper();

	private Long id;
	private String name;
	private String code;

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
	 * Entity -> DTO 변환 (List의 경우)
	 * @param categoryList
	 * @return
	 */
	public static List<CategoryResponseDto> of(List<Category> categoryList) {
		return categoryList.stream()
			.map(CategoryResponseDto::of)
			.toList();
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
