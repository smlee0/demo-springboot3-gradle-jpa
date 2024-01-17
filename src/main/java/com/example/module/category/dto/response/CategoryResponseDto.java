package com.example.module.category.dto.response;

import com.example.library.common.CommonFilter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 카테고리 응답 DTO
 *
 * @author LEESEMIN
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class CategoryResponseDto extends CommonFilter {

	private Long id;
	private String name;
	private String code;

}
