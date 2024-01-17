package com.example.module.category.service.impl;

import java.util.List;

import com.example.library.annotation.TransactionalService;
import com.example.module.category.dto.request.CategoryRequestDto;
import com.example.module.category.dto.response.CategoryResponseDto;
import com.example.module.category.mapper.CategoryMapper;
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
	public List<CategoryResponseDto> selectCategoryList(CategoryRequestDto requestDto) {
		// .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
		return CategoryMapper.INSTANCE.toList(categoryRepository.findAll());
	}

	/**
	 * 카테고리 등록
	 *
	 * @param requestDto
	 * @return
	 */
	@Override
	public void insertCategory(CategoryRequestDto requestDto) {
		categoryRepository.save(CategoryMapper.INSTANCE.toEntity(requestDto));
	}

	/**
	 * 카테고리 수정
	 *
	 * @param requestDto
	 * @return
	 */
	@Override
	public void updateCategory(CategoryRequestDto requestDto) {
		categoryRepository.save(CategoryMapper.INSTANCE.toEntity(requestDto));
	}

	/**
	 * 카테고리 삭제
	 *
	 * @param requestDto
	 * @return
	 */
	@Override
	public void deleteCategory(CategoryRequestDto requestDto) {
		categoryRepository.delete(CategoryMapper.INSTANCE.toEntity(requestDto));
	}
}
