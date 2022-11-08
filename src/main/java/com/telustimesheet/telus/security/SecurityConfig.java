package com.telustimesheet.telus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests()
				.antMatchers("/", "/auth/**", "/public/**", "/css/**", "/js/**", "/home", "/listar", "/uploads/**",
						"/fonts/**", "/productos", "/sobreNosotros", "/usuario/**", "/productos/listarShonen",
						"/productos/listarSeinen", "/productos/listar")
				.permitAll().anyRequest().authenticated()

				.and().formLogin().loginPage("/auth/login").defaultSuccessUrl("/private/index", true)
				.failureUrl("/auth/login?error=true").loginProcessingUrl("/auth/login-post").permitAll().and().logout()
				.logoutUrl("/logout").logoutSuccessUrl("/home");*/
	}

}
