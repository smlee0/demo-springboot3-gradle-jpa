package com.example.module.category.service;

import java.util.List;

import com.example.entity.Category;
import com.example.module.category.dto.CategoryRequestDto;

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
	List<Category> selectCategoryList(CategoryRequestDto requestDto);
}
