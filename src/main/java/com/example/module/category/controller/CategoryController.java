package com.example.module.category.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Category;
import com.example.library.common.CommonResponse;
import com.example.library.util.PropertyUtil;
import com.example.module.category.dto.request.CategoryRequestDto;
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
	 * TODO 프로퍼티 유틸 테스트
	 * 프로퍼티 유틸
	 */
	private final PropertyUtil propertyUtil;

	/**
	 * 카테고리 메뉴 목록 URL
	 */
	public static final String LIST_URL = "/api/v1/category";
	/**
	 * 카테고리 메뉴 등록 URL
	 */
	public static final String INSERT_URL = "/api/v1/category";
	/**
	 * 카테고리 메뉴 수정 URL
	 */
	public static final String UPDATE_URL = "/api/v1/category";
	/**
	 * 카테고리 메뉴 수정 URL
	 */
	public static final String DELETE_URL = "/api/v1/category";

	/**
	 * 카테고리 메뉴 목록 호출
	 *
	 * @return
	 */
	@GetMapping(LIST_URL)
	public ResponseEntity<CommonResponse> list(CategoryRequestDto requestDto) {
		HashMap<String, Object> map = new HashMap<>();
		List<Category> categoryList = categoryService.selectCategoryList(requestDto);
		log.debug(">>> categoryList: {}", categoryList);

		// TODO 프로퍼티 유틸 테스트
		log.debug(">>> Test PropertiesUtil Get: {}", propertyUtil.get("upload.base-path"));

		map.put("categoryList", CategoryResponseDto.of(categoryList));

		return ResponseEntity.ok().body(CommonResponse.builder().data(map).build());
	}

	/**
	 * 카테고리 메뉴 등록 액션
	 *
	 * @return
	 */
	@PostMapping(INSERT_URL)
	public ResponseEntity<CommonResponse> insert(CategoryRequestDto requestDto) {
		HashMap<String, Object> map = new HashMap<>();
		categoryService.insertCategory(requestDto);

		return ResponseEntity.ok().body(CommonResponse.builder().data(map).build());
	}

	/**
	 * 카테고리 메뉴 수정 액션
	 *
	 * @return
	 */
	@PutMapping(UPDATE_URL)
	public ResponseEntity<CommonResponse> update(CategoryRequestDto requestDto) {
		HashMap<String, Object> map = new HashMap<>();
		categoryService.insertCategory(requestDto);

		return ResponseEntity.ok().body(CommonResponse.builder().data(map).build());
	}

	/**
	 * 카테고리 메뉴 삭제 액션
	 *
	 * @return
	 */
	@DeleteMapping(DELETE_URL)
	public ResponseEntity<CommonResponse> delete(CategoryRequestDto requestDto) {
		HashMap<String, Object> map = new HashMap<>();
		categoryService.insertCategory(requestDto);

		return ResponseEntity.ok().body(CommonResponse.builder().data(map).build());
	}
}
