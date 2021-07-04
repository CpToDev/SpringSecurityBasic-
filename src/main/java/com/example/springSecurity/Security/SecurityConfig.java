package com.example.springSecurity.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Value("{myApp.authority.admin}")
    String ADMIN_AUTHORITY;

    @Value("{myApp.authority.user}")
    String USER_AUTHORITY;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("saurav").password("saurav123").authorities(ADMIN_AUTHORITY,USER_AUTHORITY).and()
                .withUser("aman").password("aman123").authorities(USER_AUTHORITY);


    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/**").hasAnyAuthority(ADMIN_AUTHORITY)
                .antMatchers("/user/**").hasAnyAuthority(USER_AUTHORITY)
                .antMatchers("/**").permitAll()
                .and().formLogin();


    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
