package com.example.module.category.service;

import java.util.List;

import com.example.module.category.dto.request.CategoryRequestDto;
import com.example.module.category.dto.response.CategoryResponseDto;

/**
 * 카테고리 서비스
 *
 * @author LEESEMIN
 */
public interface CategoryService {

	/**
	 * 카테고리 목록 호출
	 *
	 * @param requestDto
	 * @return
	 */
	List<CategoryResponseDto> selectCategoryList(CategoryRequestDto requestDto);

	/**
	 * 카테고리 등록
	 *
	 * @param requestDto
	 * @return
	 */
	void insertCategory(CategoryRequestDto requestDto);

	/**
	 * 카테고리 수정
	 *
	 * @param requestDto
	 * @return
	 */
	void updateCategory(CategoryRequestDto requestDto);

	/**
	 * 카테고리 삭제
	 *
	 * @param requestDto
	 * @return
	 */
	void deleteCategory(CategoryRequestDto requestDto);
}
