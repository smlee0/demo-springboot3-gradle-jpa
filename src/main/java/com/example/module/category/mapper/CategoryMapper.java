package com.example.module.category.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.entity.Category;
import com.example.module.category.dto.request.CategoryRequestDto;
import com.example.module.category.dto.response.CategoryResponseDto;

@Mapper
public interface CategoryMapper {
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	/**
	 * CategoryRequestDto -> Category 변환
	 *
	 * @param requestDto
	 * @return
	 */
	Category toEntity(CategoryRequestDto requestDto);

	/**
	 * Category -> CategoryResponseDto 변환
	 *
	 * @param category
	 * @return
	 */
	CategoryResponseDto toDto(Category category);

	/**
	 * List<Category> -> List<CategoryResponseDto> 변환
	 *
	 * @param categoryList
	 * @return
	 */
	List<CategoryResponseDto> toList(List<Category> categoryList);
}
