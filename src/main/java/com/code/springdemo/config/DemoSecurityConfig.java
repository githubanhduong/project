package com.code.springdemo.config;




import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;










@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource securityDataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		final String usernameQuery ="SELECT customer_id, customer_pw, customer_activated as enabled FROM customer WHERE customer_id = ? ";
		final String authQuery ="SELECT customer_id, customer_role FROM customer WHERE customer_id = ?";
		
		
		auth.jdbcAuthentication()
		.dataSource(securityDataSource)
		.usersByUsernameQuery(usernameQuery)
		.authoritiesByUsernameQuery(authQuery)
		.passwordEncoder(passwordEncoder());		
	}
	
	/*
	 * @Bean public UserDetailsService userDetailsService() { return new
	 * UserDetailsServiceImpl(); }
	 */    
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	    		.antMatchers("/css/**").permitAll()   // css적용 경로 지정 
 	            .antMatchers("/writePost/**").hasRole("CUSTOMER")
				/* .antMatchers("/priceInquiry/**").hasRole("manager") */
	            .anyRequest().permitAll() //anyRequest().authenticated() 로그인을 한 사용자만 이용할 수 있으게 설정
	        .and()
	        .formLogin()
	        .loginPage("/showMyLoginPage") //로그인 페이지 경로 지정
	        .loginProcessingUrl("/authenticateTheUser") // 사용자 이름과 암호를 제출할 URL (form:form action 부분) 
				/*
				 * .usernameParameter("customer_id") .passwordParameter("customer_pw")
				 */
	        .failureUrl("/showMyLoginPage?error=true") //로그인 실패 후 경로지정
	        .permitAll()
	        .and()
	        .logout()
			.logoutSuccessUrl("/")
	        .permitAll()
	        .and()
	        .exceptionHandling().accessDeniedPage("/acess-denied"); //접근제한 경로 설정 
	    
	    
	    CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter,CsrfFilter.class);
	    	
	}
	
	
	

}
