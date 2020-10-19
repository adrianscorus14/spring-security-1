package com.example.springsecurity1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class Config {

    //UserDetails
    //UserDetailsService->UserDetailsManager
    //PasswordEncoder

    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();

        UserDetails user1= User.withUsername("Bill").password("1234").roles("ADMIN").authorities("write").build();
        var user2=User.withUsername("John").password("1234").roles("MANAGER").authorities("read").build();

        //i used plain text only for theoretically purpose
        
        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
    }
}
