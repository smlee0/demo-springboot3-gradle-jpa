package com.example.library.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.library.annotation.RunBodyValidator;
import com.example.library.annotation.RunPathVariableValidator;
import com.example.library.error.CustomPathParamException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * RunValidatorAspect
 * RunBodyValidator, RunPathVariableValidator 어노테이션이 붙은 validator 실행
 */
@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class RunValidatorAspect {
	private final ApplicationContext applicationContext;

	/**
	 * validator 구현 클래스 실행
	 * @param joinPoint 컨트롤러, @RunBodyValidator
	 * @param runBodyValidator 어노테이션
	 * @throws BindException 바인드 익셉션
	 */
	@Before("execution(* com.example.*.controller.*.*(..)) && @annotation(runBodyValidator)")
	public void runValidatorAop(JoinPoint joinPoint, RunBodyValidator runBodyValidator) throws BindException {
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();

		Parameter[] parameters = method.getParameters();
		Object[] objs = joinPoint.getArgs();

		Object dto = null;

		for (Parameter parameter : parameters) {
			if (Arrays.stream(parameter.getAnnotations()).anyMatch(annotation -> annotation instanceof RequestBody)) {
				Validator validator = applicationContext.getBean(runBodyValidator.value());

				for (Object obj : objs) {
					if (obj.getClass().equals(parameter.getType())) {
						dto = obj;
					}
				}

				// 이름이 있으면 codes가 두개로 처리됨 처리가됨
				BindingResult bindingResult = new BeanPropertyBindingResult(dto, "");
				validator.validate(dto, bindingResult);

				if (bindingResult.hasErrors()) {
					throw new BindException(bindingResult);
				}
			}
		}
	}

	/**
	 * pathVariableValidator 구현 클래스 실행
	 * @param joinPoint 컨트롤러, @RunBodyValidator
	 * @param runPathVariableValidator 어노테이션
	 */
	@Before("execution(* com.example.*.controller.*.*(..)) && @annotation(runPathVariableValidator)")
	public void runPathValidatorAop(JoinPoint joinPoint, RunPathVariableValidator runPathVariableValidator) {
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();

		Parameter[] parameters = method.getParameters();
		Object[] objs = joinPoint.getArgs();

		Object dto = null;

		for (Parameter parameter : parameters) {
			if (Arrays.stream(parameter.getAnnotations()).anyMatch(annotation -> annotation instanceof PathVariable)) {
				PathVariableValidator validator = applicationContext.getBean(runPathVariableValidator.value());

				for (Object obj : objs) {
					if (obj.getClass().equals(parameter.getType())) {
						dto = obj;
					}
				}

				CustomPathParamException exception = validator.validate(dto);

				if (exception != null) {
					throw exception;
				}
			}
		}
	}

}
