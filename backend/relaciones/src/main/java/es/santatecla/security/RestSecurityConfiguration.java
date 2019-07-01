package es.santatecla.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Order(1)
@Configuration
public class RestSecurityConfiguration extends WebSecurityConfigurerAdapter{
		
		
	@Autowired
	public UserRepositoryAuthProvider authenticationProvider;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		// Public pages
				http.authorizeRequests().antMatchers(HttpMethod.GET,"/units").permitAll();
				http.authorizeRequests().antMatchers(HttpMethod.GET,"/login").authenticated();
								
				
		// Private pages
				
//				http.authorizeRequests().antMatchers(HttpMethod.GET, "/unit/**" ).hasRole("USER");
				http.authorizeRequests().antMatchers(HttpMethod.GET, "/unit/**" ).permitAll();
//				http.authorizeRequests().antMatchers(HttpMethod.POST,"/**").hasRole("ADMIN");
				http.authorizeRequests().antMatchers(HttpMethod.POST,"/**").permitAll();
//				http.authorizeRequests().antMatchers(HttpMethod.POST,"/addRelation").hasRole("ADMIN");
//				http.authorizeRequests().antMatchers(HttpMethod.POST,"/add-record").hasRole("ADMIN");
//				http.authorizeRequests().antMatchers(HttpMethod.POST,"/addUnit").hasRole("ADMIN");
//				http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN");
				http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/**").permitAll();
//				http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/deleteRelation/**").hasRole("ADMIN");
//				http.authorizeRequests().antMatchers(HttpMethod.PUT, "/edit-record/**").hasRole("ADMIN");
				http.authorizeRequests().antMatchers(HttpMethod.PUT, "/edit-record/**").permitAll();
				
		// Disabled csrf in api rest		
				http.csrf().disable();
				
	   //Http Authentication		
				http.httpBasic();
				
				http.logout().logoutSuccessHandler((re, rs, a) -> {   });
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}
}
