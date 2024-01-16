package com.example.module.category.dto.response;

import java.util.List;

import com.example.module.category.dto.request.CategoryRequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * 카테고리 응답 DTO
 *
 * @author LEESEMIN
 */
@Getter
@Builder
@AllArgsConstructor
public class CategoryResponse {

	private List<CategoryRequestDto> category;

}
