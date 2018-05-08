package ShoppingMall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{


	@Override
	protected void configure(HttpSecurity http) throws Exception {
          http.authorizeRequests()
          .antMatchers("/admin/**").access(" isFullyAuthenticated() and FuhasRloe('ADMIN')")
          .antMatchers("/assets/**","/login").permitAll()
          .antMatchers("/**").authenticated()
          
          .and()
          .formLogin()
          .loginPage("/login")
          .and()
          .rememberMe()
          .tokenValiditySeconds(7*24*3600)
          ;
	}
}
