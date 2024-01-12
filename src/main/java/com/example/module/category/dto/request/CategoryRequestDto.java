package com.example.module.category.dto.request;

import com.example.entity.Category;

import lombok.Builder;
import lombok.Data;

/**
 * 카테고리 요청 DTO
 *
 * @author LEESEMIN
 */
@Data
@Builder
public class CategoryRequestDto {
	private Long id;
	private String name;
	private String code;
	private Integer sortNo;

	/**
	 * DTO -> Entity 변환
	 *
	 * @return
	 */
	public Category toEntity() {
		return Category.builder()
			.id(id)
			.name(name)
			.code(code)
			.sortNo(sortNo)
			.build();
	}

}
