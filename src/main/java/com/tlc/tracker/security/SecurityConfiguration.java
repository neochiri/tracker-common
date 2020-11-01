package com.tlc.tracker.security;

import com.tlc.tracker.security.filter.JWTAuthenticationFilter;
import com.tlc.tracker.security.filter.JWTAuthorizationFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@ComponentScan
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.cors().disable()
				.csrf().disable()
				.headers().frameOptions().disable().and()
				.authorizeRequests().antMatchers("/h2-console/**").permitAll().and()
				.authorizeRequests().antMatchers("/actuator/**").permitAll().and()
				.authorizeRequests().antMatchers("/docs/index.html").permitAll().and()
				.authorizeRequests().antMatchers("/login").permitAll().and()
				.authorizeRequests().anyRequest()
				.authenticated().and()
				.addFilter(new JWTAuthorizationFilter(authenticationManager()))
				.addFilter(new JWTAuthenticationFilter(authenticationManager()));
	}
}
