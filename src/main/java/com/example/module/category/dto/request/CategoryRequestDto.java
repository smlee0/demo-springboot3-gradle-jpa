package com.example.module.category.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 카테고리 요청 DTO
 *
 * @author LEESEMIN
 */
@Getter
@Setter
@Builder
public class CategoryRequestDto {

	private Long id;
	@NotBlank(message = "카테고리 명을 입력해 주세요.")
	private String name;
	@NotBlank(message = "카테고리 코드를 입력해 주세요.")
	private String code;

}
