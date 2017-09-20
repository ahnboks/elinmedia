package com.ahn.springboot.security;

import com.ahn.springboot.domain.WideSession;
import com.ahn.springboot.persistence.WideSessionRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Log
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
    @Autowired
    WideAdminDetailService wideAdminDetailService;

    @Autowired
    WideSessionRepository wideSessionRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        log.info("configure 설정");


        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin/advertiser/**").hasAnyRole("MA","AD")
                .antMatchers("/admin/partner/**").hasAnyRole("MA","PT")
                .antMatchers("/admin/**").hasAnyRole("MA")
                .and().formLogin()
                .loginProcessingUrl("/login")
                .permitAll()
                .loginPage("/login").defaultSuccessUrl("/admin/main",true)
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/login");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        log.info("Build Auth Global!!! passwordEncoder");
        auth.userDetailsService(wideAdminDetailService)
                .passwordEncoder(passwordEncoder());
    }
}
