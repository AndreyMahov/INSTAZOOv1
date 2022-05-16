package com.example.instazoo_v1.security;

public class SecurityConstants {
    public static final String SIGN_UP_URS = "/api/auth/**";
    public static final String SECRET = "SecretKeyGenJWT";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String CONTENT_TYPE = "Application/json";
    public static final long EXPIRATION_TIME = 600_000;// 10Min
}
