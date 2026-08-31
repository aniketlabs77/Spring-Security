package com.aniket.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	//Authorization
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
		http.authorizeHttpRequests(request->
			request
//			.anyRequest().permitAll()); //All urls are accessible. No Authorization or Authentication needed. 
//			.requestMatchers("/","/error").permitAll()
//			.requestMatchers("/demo1").hasRole("USER")
//			.requestMatchers("/demo2").hasRole("ADMIN")
//			.requestMatchers("/demo3").hasAnyRole("USER", "ADMIN")
//			.requestMatchers("/demo4").authenticated()
//			.anyRequest().authenticated())
		
			
			.requestMatchers("/demo1").hasRole("USER")
			.requestMatchers("/demo2").hasRole("ADMIN")
			.requestMatchers("/demo3").hasAnyRole("USER", "ADMIN")
			.requestMatchers("/demo4").authenticated()
			.anyRequest().permitAll())
		
			
//			.formLogin(withDefaults()) //default spring login page.
			.formLogin((form) -> form.loginPage("/applogin").permitAll())
			.logout((logout) -> logout.logoutSuccessUrl("/").permitAll()) //to redirect to specific page
			.exceptionHandling(handling -> handling.accessDeniedPage("/accessDenied"));
		
//			http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
	//Authentication
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails user1 = User.withDefaultPasswordEncoder().username("rr").password("ram").roles("USER").build();
		UserDetails user2 = User.withDefaultPasswordEncoder().username("kk").password("kk12").roles("ADMIN").build();
		UserDetails user3 = User.withDefaultPasswordEncoder().username("pp").password("pp12").roles("USER").build();
		UserDetails user4 = User.withDefaultPasswordEncoder().username("yy").password("yy12").roles("MANAGER").build();
		return new InMemoryUserDetailsManager(user1,user2,user3,user4);
	}
}

