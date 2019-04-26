package com.example.smdemo1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
			.disable()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET,
					"/",
					"/*html",
					"favicon.ico",
					"/**/*.js",
					"/**/*.css",
					"/swagger-ui.html/**",
					"/swagger-resources/**",
					"/v2/api-doc/**"
			)
			.permitAll()
			.antMatchers("/auth/**","/actuator/**")
			.permitAll()
			.antMatchers(HttpMethod.OPTIONS)
			.permitAll()
				//测试全部运行访问
			.antMatchers("/**")
			.permitAll()
			.anyRequest()
			.authenticated();

	}
}
