package com.example.library.error;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.library.error.response.ErrorDto;
import com.example.library.error.response.ValidationErrorDto;
import com.example.library.exception.CustomPathParamException;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

/**
 * 글로벌 예외 처리
 *
 * @author LEESEMIN
 */
@Slf4j
@ControllerAdvice
public class ValidationControllerAdvice {
	/**
	 * 제약조건 위반
	 * @param e 에러내용
	 * @return error
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationErrorDto onConstraintValidationException(ConstraintViolationException e) {
		log.info("[Exception] ConstraintViolationException");
		ValidationErrorDto error = new ValidationErrorDto();
		for (ConstraintViolation violation : e.getConstraintViolations()) {
			error.getErrors().add(
				new ErrorDto(violation.getPropertyPath().toString(), violation.getMessage()));
		}
		return error;
	}

	/**
	 * valid 어노테이션 유효청 체크 실패
	 * @param e 에러내용
	 * @return error
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationErrorDto onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		log.info("[Exception] MethodArgumentNotValidException");
		ValidationErrorDto error = new ValidationErrorDto();

		// validator + 필드 에러
		for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
			if (objectError instanceof FieldError) {
				FieldError fieldError = (FieldError)objectError;
				error.getErrors().add(
					new ErrorDto(fieldError.getCode() + " " + fieldError.getField(), objectError.getDefaultMessage()));
			} else {
				error.getErrors().add(
					new ErrorDto(objectError.getCode(), objectError.getDefaultMessage()));
			}

		}

		return error;
	}

	/**
	 * 요청한 타입과 실제타입과 다를 때
	 * @param e 에러내용
	 * @return error
	 */
	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationErrorDto bindValidException(BindException e) {
		log.info("[Exception] BindException");
		ValidationErrorDto error = new ValidationErrorDto();
		for (ObjectError err : e.getBindingResult().getAllErrors()) {
			error.getErrors().add(
				new ErrorDto(err.getCode(), err.getDefaultMessage()));
		}
		return error;
	}

	/**
	 * 요청한 타입과 실제타입과 다를 때
	 * @param e 에러내용
	 * @return error
	 */
	@ExceptionHandler(CustomPathParamException.class)
	@ResponseBody
	ValidationErrorDto customPathParamException(HttpServletResponse response, CustomPathParamException e) {
		log.info("[Exception] CustomPathParamException");
		ValidationErrorDto error = new ValidationErrorDto();
		error.getErrors().add(new ErrorDto(e.getCode(), e.getMessage()));
		response.setStatus(e.getHttpStatus().value());
		if (e.getHttpStatus().equals(HttpStatus.NOT_FOUND)) {
			return null;
		} else {
			return error;
		}
	}
}
