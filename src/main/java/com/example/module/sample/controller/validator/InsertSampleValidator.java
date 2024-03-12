package com.example.module.sample.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.library.annotation.TransactionalComponent;
import com.example.module.sample.dto.request.SampleInsertRequestDto;
import com.example.module.sample.repository.SampleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 샘플 등록 밸리데이터
 *
 * @author LEESEMIN
 */
@Slf4j
@RequiredArgsConstructor
@TransactionalComponent
public class InsertSampleValidator implements Validator {

	private final SampleRepository sampleRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return SampleInsertRequestDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (errors.hasErrors()) {
			return;
		}

		SampleInsertRequestDto requestDto = (SampleInsertRequestDto)target;

		// Sealed 클래스를 통해 getter가 생성될 경우 getName이 아니라 name으로 가져올 수 있도록 변경됨
		if (sampleRepository.existsByName(requestDto.getName())) {
			errors.reject("name already exist", "이미 등록된 이름 입니다.");
		}
	}
}
