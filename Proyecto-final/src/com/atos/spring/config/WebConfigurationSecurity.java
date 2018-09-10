package com.atos.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.atos.spring.service.UserService;

@Configuration
@EnableWebSecurity
@ImportResource("classpath:/com/atos/spring/modelo.xml")
public class WebConfigurationSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userService;
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth)
	{
		DaoAuthenticationProvider daoAuth = new DaoAuthenticationProvider();
		//daoAuth.setPasswordEncoder(encoder());
		daoAuth.setUserDetailsService(userService); //mi servicio que debe implementar UserDetailsService, solo se usa para logueo
		auth.authenticationProvider(daoAuth);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().antMatchers("/xhtml/**").hasAnyRole("ADMIN","USER").anyRequest().authenticated();
		http.formLogin().loginPage("/login.jsp").permitAll();
		http.formLogin().loginProcessingUrl("/doLogin").permitAll(); //importante, es la url request del servlet de login de spring security (post)
		http.formLogin().usernameParameter("das").passwordParameter("password");
		http.formLogin().successForwardUrl("/loginSuccess"); //post
		http.logout().logoutUrl("/doLogout").logoutSuccessUrl("/login.jsp").permitAll();
		//http.exceptionHandling().accessDeniedPage("/control/403");
	}
	
}
