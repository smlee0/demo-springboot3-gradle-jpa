package com.example.library.security.jwt;

public class JwtException extends RuntimeException{

    public JwtException(String message) {
        super(message);
    }
}