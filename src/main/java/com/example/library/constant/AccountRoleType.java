package com.example.library.constant;

import lombok.Getter;

@Getter
public enum AccountRoleType {
	/* product ctgry */
	USER("USER"),

	/* update ctgry */
	ADMIN("ADMIN");

	private final String code;

	AccountRoleType(String code) {
		this.code = code;
	}

	public static boolean isValid(String code) {
		boolean result = false;
		for (AccountRoleType value : values()) {
			if (value.getCode().equals(code)) {
				result = true;
				break;
			}
		}
		return result;
	}
}

