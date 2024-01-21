package com.example.module.sample.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.library.annotation.TransactionalComponent;
import com.example.module.sample.dto.request.SampleRequestDto;
import com.example.module.sample.repository.SampleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 샘플 수정 밸리데이터
 *
 * @author LEESEMIN
 */
@Slf4j
@RequiredArgsConstructor
@TransactionalComponent
public class UpdateSampleValidator implements Validator {

	private final SampleRepository sampleRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return SampleRequestDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (errors.hasErrors()) {
			return;
		}

		SampleRequestDto requestDto = (SampleRequestDto)target;

		if (sampleRepository.existsByName(requestDto.getName())) {
			errors.reject("name already exist", "이미 등록된 이름 입니다.");
		}
	}
}
