package com.example.library.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 커스텀 익셉션
 *
 * @author LEESEMIN
 */
@AllArgsConstructor
@Setter
@Getter
public class CustomPathParamException extends RuntimeException {
	private HttpStatus httpStatus;
	private String code;
	private String message;
}
