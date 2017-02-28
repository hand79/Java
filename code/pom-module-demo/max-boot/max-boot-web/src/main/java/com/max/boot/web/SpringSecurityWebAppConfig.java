package com.max.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityWebAppConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		  http
          .authorizeRequests()
          	  .antMatchers("/login*").anonymous()
              .antMatchers("/static/**", "/loginForm**").permitAll()
              .anyRequest().authenticated()
              .and()
          .formLogin()
              .loginPage("/loginForm")
              .usernameParameter("username")
              .passwordParameter("password")
              .defaultSuccessUrl("/index", false)
              .loginProcessingUrl("/j_spring_security_check")
              .failureUrl("/loginForm?type=fail")
              .and()
          .logout()
          	.logoutUrl("/loginForm?type=logout")
            .permitAll();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
		web.ignoring().antMatchers("/static/**","/font-awesome/**","/css/**","/js/**","/images/**");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("admin").password("admin").roles("ADMIN");
//		auth.jdbcAuthentication().dataSource(dataSource)
//    	.usersByUsernameQuery("select user_id, password, enabled from users where user_id=?")
//    	.authoritiesByUsernameQuery("select user_id, roles from users where user_id=?")
//    	.passwordEncoder(new BCryptPasswordEncoder());
	}
		
}

