package com.example.module.category.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Category;
import com.example.module.category.dto.request.CategoryRequestDto;
import com.example.module.category.dto.request.InsertCategoryRequestDto;
import com.example.module.category.dto.response.CategoryResponseDto;
import com.example.module.category.service.CategoryService;

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
	private final CategoryService categoryService;

	/**
	 * 카테고리 메뉴 목록 호출
	 *
	 * @return
	 */
	@GetMapping("/api/v1/category")
	public ResponseEntity<Object> list(CategoryRequestDto requestDto) {
		List<Category> categoryList = categoryService.selectCategoryList(requestDto);
		log.debug(">>> categoryList: {}", categoryList);

		return ResponseEntity.ok().body(CategoryResponseDto.of(categoryList));
	}

	/**
	 * 카테고리 메뉴 등록 액션
	 *
	 * @return
	 */
	@PostMapping("/api/v1/category")
	public ResponseEntity<Object> insert(InsertCategoryRequestDto requestDto) {
		categoryService.insertCategory(requestDto);

		return ResponseEntity.ok().build();
	}

	/**
	 * 카테고리 메뉴 수정 액션
	 *
	 * @return
	 */
	@PutMapping("/api/v1/category")
	public ResponseEntity<Object> update(CategoryRequestDto requestDto) {
		categoryService.updateCategory(requestDto);

		return ResponseEntity.ok().build();
	}

	/**
	 * 카테고리 메뉴 삭제 액션
	 *
	 * @return
	 */
	@DeleteMapping("/api/v1/category")
	public ResponseEntity<Object> delete(CategoryRequestDto requestDto) {
		categoryService.deleteCategory(requestDto);

		return ResponseEntity.ok().build();
	}
}
