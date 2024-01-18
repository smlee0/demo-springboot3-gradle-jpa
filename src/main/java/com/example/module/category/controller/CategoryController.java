package com.example.module.category.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.module.category.dto.request.CategoryRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 카테고리 컨트롤러
 *
 * @author LEESEMIN
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class CategoryController {
	/**
	 * 카테고리 서비스
	 */
	// private final CategoryService categoryService;

	/**
	 * 카테고리 목록 호출
	 *
	 * @return
	 */
	@GetMapping("/api/v1/category")
	public ResponseEntity<?> list(CategoryRequestDto requestDto) {
		return null;
	}
}
