package com.xinyonghang.supplychain.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

        //TODO 加密需要修改
        auth.userDetailsService(customUserService()).passwordEncoder(new MyPasswordEncoder());

//        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("bill").password("abc123").roles("USER");
//        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("admin").password("root123").roles("ADMIN");
//        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("dba").password("root123").roles("ADMIN","DBA");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
        // 设置本域名下iframe可以访问
        http.headers().frameOptions().sameOrigin();
        http.csrf().disable();
        // 设置同一帐号只能存在一个session
//        http.sessionManagement().maximumSessions(1);
//        http.authorizeRequests()
//                .antMatchers("/index").hasRole("USER")
//                .antMatchers("/mk/attribute/*").hasRole("USER")//设置属性管理的页面需要admin权限
//                .anyRequest().authenticated()
//                .and().formLogin().successForwardUrl("/hello");
    }


}