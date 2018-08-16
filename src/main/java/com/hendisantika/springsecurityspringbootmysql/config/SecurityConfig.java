package com.hendisantika.springsecurityspringbootmysql.config;

import com.hendisantika.springsecurityspringbootmysql.repository.UserRepository;
import com.hendisantika.springsecurityspringbootmysql.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-spring-boot-mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/08/18
 * Time: 06.13
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new AuthenticationFailureHandler();
    }

    /*
     * Tell Spring Security to use the custom built UserDetailsServiceImpl class
     *
     */
    @Override
    protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.userDetailsService(userDetailsServiceBean()).passwordEncoder(passwordEncoder());
    }

    @Override
    public UserDetailsService userDetailsServiceBean() {
        return new UserDetailsServiceImpl(userRepository);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //you can either disable this or
                //put <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                //inside the login form
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/user/**").hasAuthority("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") //enable this to go to your own custom login page
                //.loginProcessingUrl("/login") //enable this to use login page provided by spring security
                .failureUrl("/login?error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout");
    }

    /*
     *
     * These resources are available to every users
     */
    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/js**")
                .antMatchers("/images/**")
                .antMatchers("/css/**")
                .antMatchers("/templates/**");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}