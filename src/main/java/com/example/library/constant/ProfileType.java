package com.example.library.constant;

/**
 * 환경 변수 타입 ENUM
 *
 * @author LEESEMIN
 */
public enum ProfileType {
	LOCAL,
	DEVELOP,
	STAGING,
	PRODUCTION;

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}

	private ProfileType() {
	}
}
