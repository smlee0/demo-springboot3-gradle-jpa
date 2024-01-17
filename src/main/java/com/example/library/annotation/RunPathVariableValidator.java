package com.example.library.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.library.aop.PathVariableValidator;

/**
 * PathVariable 벨리데이터 실행
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RunPathVariableValidator {
	Class<? extends PathVariableValidator> value();
}
