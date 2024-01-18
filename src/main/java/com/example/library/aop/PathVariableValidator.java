package com.example.library.aop;

import com.example.library.error.CustomPathParamException;

/**
 * AOP > PathVariable Validator 인터페이스
 *
 * @author LEESEMIN
 */
public interface PathVariableValidator {
	CustomPathParamException validate(Object object);
}
