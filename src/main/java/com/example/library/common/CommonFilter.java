package com.example.library.common;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.library.util.DateUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 공통 필터 클래스
 *
 * @author LEESEMIN
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class CommonFilter {
	/**
	 * 현재 날짜 (yyyy-mm-dd)
	 */
	private String nowDay = DateUtil.now();
	/**
	 * 현재 시간 (yyyy-mm-dd HH:mm:00)
	 */
	private String nowMin = DateUtil.now("yyyy-MM-dd HH:mm:00");
	/**
	 * 모드
	 */
	private String mode;
	/**
	 * 언어
	 */
	private String lang;
	/**
	 * 등록자 ID
	 */
	private String regId;
	/**
	 * 등록일시
	 */
	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATE_TIME_PATTERN)
	private LocalDateTime regDt;
	/**
	 * 수정자 ID
	 */
	private String updId;
	/**
	 * 수정일시
	 */
	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATE_TIME_PATTERN)
	private LocalDateTime updDt;
}

