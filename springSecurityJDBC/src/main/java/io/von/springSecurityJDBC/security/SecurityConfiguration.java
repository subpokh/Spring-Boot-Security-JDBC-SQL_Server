package io.von.springSecurityJDBC.security;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// CREATE CORRESPONDING TABLES- users and authorities AS PER SPRING DOCUMENTATIONS IN SQL SERVER AND POPULATE THEM WITH DATAS
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(getPasswordEncoder())
			.usersByUsernameQuery("select username, password, enabled "
					+ "from users "
					+ "where username = ?")
			.authoritiesByUsernameQuery("select username,authority "
					+ "from authorities "
					+ "where username = ?");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests()
			.antMatchers("/api/mgr", "/api/mgr/*").hasRole("ADMIN")
			.antMatchers("/api/emp","/api/emp/*").hasAnyRole("ADMIN", "USER")
			.antMatchers("/api/all","/api/all/*").permitAll()
			.and().formLogin();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
}
