package com.atos.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebConfigurationSecurity extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests().antMatchers("/xhtml/**").hasAnyRole("ADMIN","USER").anyRequest().authenticated();
		http.formLogin().loginPage("/login.jsp").permitAll();
		http.formLogin().loginProcessingUrl("/doLogin").permitAll(); //importante, es la url request del servlet de login de spring security (post)
		http.formLogin().usernameParameter("username").passwordParameter("password");
		http.logout().logoutUrl("/doLogout").logoutSuccessUrl("/logout.jsp").permitAll();
		http.exceptionHandling().accessDeniedPage("/forbidden.jsp");*/
		
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login.xhtml").permitAll();
		http.formLogin().loginProcessingUrl("/doLogin").permitAll();
		http.formLogin().usernameParameter("username").passwordParameter("password");
		http.exceptionHandling().accessDeniedPage("/forbidden.jsp");
		/*http.formLogin().failureUrl("/error.html");
		http.formLogin().defaultSuccessUrl("/test.jsp",true);*/
	}
	
}
