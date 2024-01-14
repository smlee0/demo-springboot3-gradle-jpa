package com.example.library.common;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.library.util.DateUtil;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 공통 필터 클래스
 *
 * @author LEESEMIN
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class CommonFilter {
	/**
	 * 모드
	 */
	// private String mode;
	/**
	 * 언어
	 */
	// private String lang;
	/**
	 * 등록일시
	 */
	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATE_TIME_PATTERN)
	private LocalDateTime createDt;
	/**
	 * 등록자 ID
	 */
	private String createId;
	/**
	 * 수정일시
	 */
	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATE_TIME_PATTERN)
	private LocalDateTime modifyDt;
	/**
	 * 수정자 ID
	 */
	private String modifyId;
}

