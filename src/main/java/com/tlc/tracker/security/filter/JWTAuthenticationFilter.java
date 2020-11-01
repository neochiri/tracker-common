package com.tlc.tracker.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tlc.tracker.security.model.UserSecurity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		try{
			UserSecurity user = new ObjectMapper().readValue(request.getInputStream(), UserSecurity.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					user.getEmail(), user.getPassword(), new ArrayList<>()
			));
		}catch(IOException e){
		}
		return null;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
		String token = Jwts.builder()
				.setIssuedAt(new Date())
				.setIssuer("test-tracker")
				.setSubject(((User)authResult.getPrincipal()).getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong("100000")))
				.signWith(SignatureAlgorithm.HS512, "secret-key").compact();
		response.addHeader("Authorization", "Bearer " + token);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		User user = (User) authResult.getPrincipal();
		response.getWriter().print(new ObjectMapper().writeValueAsString(user));
	}
}
