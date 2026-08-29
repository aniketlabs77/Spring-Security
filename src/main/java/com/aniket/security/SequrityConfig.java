package com.aniket.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SequrityConfig {

	// Authorization
	@Bean
	public SecurityFilterChain sequrityFilterChain(HttpSecurity http) {
		http.authorizeHttpRequests(request -> request
//				.anyRequest().permitAll();  -> All urls are accessible. No Authorization or Authentication needed.

				.requestMatchers("/").permitAll()
				.requestMatchers("/demo1").hasRole("USER")
				.requestMatchers("/demo2").hasRole("ADMIN")
				.requestMatchers("/demo3").hasAnyRole("USER", "ADMIN")
				.anyRequest().authenticated())
				.formLogin(withDefaults()) // default spring login page.

//				.logout((logout) -> logout.permitAll()) //take you to login page , but optional
				.logout((logout) -> logout.logoutSuccessUrl("/").permitAll())
				.exceptionHandling(handling -> handling.accessDeniedPage("/accessDenied"));

		return http.build();
	}

	// Authentication
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails user1 = User.withDefaultPasswordEncoder().username("Aniket").password("aniket").roles("USER").build();
		UserDetails user2 = User.withDefaultPasswordEncoder().username("Alex").password("alex").roles("ADMIN").build();
		UserDetails user3 = User.withDefaultPasswordEncoder().username("John").password("john").roles("USER").build();

		return new InMemoryUserDetailsManager(user1, user2, user3);
	}

}
