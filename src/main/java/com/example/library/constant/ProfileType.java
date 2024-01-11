package com.example.library.constant;

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
