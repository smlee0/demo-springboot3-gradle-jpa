package com.example.library.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

/**
 * Transactional + service 어노테이션
 */
@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Transactional
@Service
public @interface TransactionalService {
}
