package com.example.module.category.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.library.annotation.TransactionalComponent;
import com.example.module.category.dto.request.CategoryRequestDto;
import com.example.module.category.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 카테고리 등록 밸리데이터
 *
 * @author LEESEMIN
 */
@Slf4j
@RequiredArgsConstructor
@TransactionalComponent
public class InsertCategoryValidator implements Validator {

	private final CategoryRepository categoryRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoryRequestDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (errors.hasErrors()) {
			return;
		}

		CategoryRequestDto requestDto = (CategoryRequestDto)target;

		if (categoryRepository.existsByName(requestDto.getName())) {
			errors.reject("name already exist", "이미 존재하는 토픽 이름입니다.");
		}
	}
}
