package com.example.library.util;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * 프로퍼티 유틸
 *
 * @author LEESEMIN
 */
@Component
@RequiredArgsConstructor
public class PropertyUtil {

	private final Environment environment;

	public String get(String name) {
		return environment.getProperty(name);
	}

}