package com.example.module.category.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Category;
import com.example.library.common.CommonResponse;
import com.example.module.category.dto.request.CategoryRequestDto;
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
	 * 브랜드 제품 목록 URL
	 */
	public static final String LIST_URL = "/api/v1/category";

	/**
	 * 카테고리 메뉴 목록 호출
	 *
	 * @return
	 */
	@GetMapping(LIST_URL)
	public ResponseEntity<CommonResponse> categoryList(CategoryRequestDto requestDto) {
		HashMap<String, Object> map = new HashMap<>();
		List<Category> categoryList = categoryService.selectCategoryList(requestDto);
		log.debug(">>> categoryList: {}", categoryList);

		map.put("categoryList", categoryList);

		return ResponseEntity.ok().body(CommonResponse.builder().data(map).build());
	}
}
