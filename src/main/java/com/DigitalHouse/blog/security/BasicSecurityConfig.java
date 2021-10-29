package com.DigitalHouse.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity  //primeira annotation informando que usaremos o Spring Security
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired //injeção de dependência de segurança nesta classe -> Spring Security
    private UserDetailsService userDetailsService;

    @Override  //gerenciar a autorização de acesso
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean //tipo de encriptação de dados / senha
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //CONFIGURAÇÃO - olhando as requisições http ou simplesmente url's
    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/usuario/logar").permitAll()
                .antMatchers("/usuario/cadastrar").permitAll()
//                .anyRequest().authenticated()
                .and().httpBasic()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().cors()
                .and().csrf().disable();
    }
}
