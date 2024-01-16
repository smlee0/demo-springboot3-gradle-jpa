package com.example.library.error.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import lombok.Getter;
import lombok.Setter;

/**
 * error response
 */
@Getter
@Setter
public class ValidationErrorDto {
	private List<ErrorDto> errors = new ArrayList<>();

	/**
	 * Controller return valid error 를 위한 bindingResult
	 * @param bindingResult 에러 bind 내용
	 * @return 에러 response
	 */
	public ValidationErrorDto bindingResult(BindingResult bindingResult) {
		for (ObjectError error : bindingResult.getAllErrors()) {
			this.errors.add(new ErrorDto(error.getCode(), error.getDefaultMessage()));
		}
		return this;
	}

	public ValidationErrorDto setValidErrors(List<ErrorDto> errorDtoList) {
		this.errors = errorDtoList;
		return this;
	}
}
