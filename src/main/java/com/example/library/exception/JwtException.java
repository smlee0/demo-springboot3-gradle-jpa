package com.example.library.exception;

/**
 * JWT 익셉션
 *
 * @author LEESEMIN
 */
public class JwtException extends RuntimeException {

	public JwtException(String message) {
		super(message);
	}
}