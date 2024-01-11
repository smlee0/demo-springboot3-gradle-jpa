package com.example.module.category.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Category;
import com.example.module.category.dto.CategoryRequestDto;
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
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	/**
	 * 카테고리 레포지토리
	 */
	private static CategoryRepository categoryRepository;

	/**
	 * 카테고리 목록 호출
	 *
	 * @param requestDto
	 * @return
	 */
	@Override
	public List<Category> selectCategoryList(CategoryRequestDto requestDto) {
		return categoryRepository.findAll();
	}
}
