package com.sound.mall.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private static final String SALT = "SSAFIT";

	public String createToken(String key, String value) throws UnsupportedEncodingException {
		return Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT") // 헤더완료
				.claim(key, value).signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) // 서명완료
				.compact();
	}

	public void valid(String token) throws Exception {
		Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token);
	}

	public String extractUserId(String token) {
		if (token.startsWith("Bearer ")) {
		    token = token.substring(7);
		}
		Claims claims = Jwts.parser()
		    .setSigningKey(SALT.getBytes(StandardCharsets.UTF_8))
		    .parseClaimsJws(token)
		    .getBody();

		return claims.get("userId", String.class);
	}
}