package com.example.library.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 공통 유틸 클래스
 *
 * @author LEESEMIN
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonUtil {

	/**
	 * Ajax 요청 인지 여부
	 *
	 * @return Ajax 요청 여부
	 */
	public static boolean isAjax() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		return StringUtils.equals(request.getHeader("X-Requested-With"), "XMLHttpRequest");
	}

}
