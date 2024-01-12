package com.example.module.category.service.impl;

import java.util.List;

import com.example.entity.Category;
import com.example.library.annotation.TransactionalService;
import com.example.module.category.dto.request.CategoryRequestDto;
import com.example.module.category.repository.CategoryRepository;
import com.example.module.category.service.CategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 카테고리 서비스 구현부
 *
 * @author LEESEMIN
 */
@Slf4j
@RequiredArgsConstructor
@TransactionalService
public class CategoryServiceImpl implements CategoryService {

	/**
	 * 카테고리 레포지토리
	 */
	private final CategoryRepository categoryRepository;

	/**
	 * 카테고리 목록 호출
	 *
	 * @param requestDto
	 * @return
	 */
	@Override
	public List<Category> selectCategoryList(CategoryRequestDto requestDto) {
		// .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
		return categoryRepository.findAll();
	}
}
