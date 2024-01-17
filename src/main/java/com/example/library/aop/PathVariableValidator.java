package com.example.library.aop;

import com.example.library.error.CustomPathParamException;

/**
 * pathvariable validator interface
 */
public interface PathVariableValidator {
	CustomPathParamException validate(Object object);
}
