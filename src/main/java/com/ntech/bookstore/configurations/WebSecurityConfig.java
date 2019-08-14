/***
 ** Created By Francois ASSOGBA at 09/05/2019 for bookstore
 ***/

package com.ntech.bookstore.configurations;

import com.ntech.bookstore.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UtilisateurService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/resources/**", "/css/**", "/js/**", "/img/**", "/vendor/**").permitAll()
                .antMatchers("/signup", "/signup/**", "/home").permitAll()
                .antMatchers("/books", "/books/**").permitAll()
                .antMatchers("/editor").access("hasAnyAuthority('EDITOR', 'ADMIN')")
                .antMatchers("/admin").access("hasAuthority('ADMIN')")
                .anyRequest().authenticated()
            .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error").permitAll()
            .and().logout()
                .logoutUrl("/logout")
                .deleteCookies("remember-me")
                .logoutSuccessUrl("/login?logout").permitAll()
            .and().rememberMe()
            .and().exceptionHandling()
                .accessDeniedPage("/accessDenied")
            .and().csrf();
    }
    //                .antMatchers("/VAADIN/**", "/PUSH/**", "/UIDL/**", "/error/**", "/vaadinServlet/**").permitAll()
//                .antMatchers("/client").access("hasAnyAuthority('CLIENT', 'EDITOR', 'ADMIN')")

}
