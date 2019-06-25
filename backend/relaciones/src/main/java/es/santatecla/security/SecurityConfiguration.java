package es.santatecla.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


	@Autowired
	public UserRepositoryAuthProvider authenticationProvider;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		// Public pages
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/index").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/loginerror").permitAll();
		http.authorizeRequests().antMatchers("/logout").permitAll();
		

		
		//Private pages
		http.authorizeRequests().antMatchers("/alumn-units").hasAnyRole("USER","ADMIN");
		http.authorizeRequests().antMatchers("/unit/add-unit/*").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/unit/delete-unit/*").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/unit/**").hasAnyRole("ADMIN");
		

		// Login form
        http.formLogin().loginPage("/");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/loginerror");
        
     // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
        
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
//	auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
	}
}
