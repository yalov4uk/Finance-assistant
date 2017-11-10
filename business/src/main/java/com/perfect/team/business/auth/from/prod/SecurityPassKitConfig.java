package com.perfect.team.business.auth.from.prod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@Order(1)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityPassKitConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenAuthenticationManager tokenAuthenticationManager;

    @Autowired
    public TokenAuthenticationFilter tokenAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(tokenAuthenticationFilter, BasicAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("API")
                .antMatchers("/external/**").hasRole("API")
                .antMatchers(
                        "/v1/devices/{deviceLibraryIdentifier}/registrations/{passTypeIdentifier}/{serialNumber}",
                        "/v1/passes/{passTypeIdentifier}/{serialNumber}"
                        //"/external/**"
                    ).hasRole("TOKEN")
                .anyRequest().permitAll()
        ;
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return tokenAuthenticationManager;
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return tokenAuthenticationManager;
    }
}
