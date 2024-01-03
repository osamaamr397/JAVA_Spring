package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


//this InMemoryUserDetailsManager will save the data in memory not DB
@Configuration

public class DemoSecurityConfig {
    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails amr= User.builder().
                username("osamaamr397").
                password("{noop}test123").
                roles("EMPLOYEE").build();
        UserDetails osama=User.builder().
                username("osama").
                password("{noop}test123").
                roles("EMPLOYEE","MANAGER").
                build();
        UserDetails mohamed=User.builder().
                username("mo").
                password("{noop}test123").
                roles("EMPLOYEE","MANAGER","ADMIN").
                build();
        return new InMemoryUserDetailsManager(amr,osama,mohamed);
    }
    */

    /*
    this for spring security JDBC authentication without custom table
    this depend on the JDBC or spring Configuration in db which have
    table called User and another table called authorities

     //add support for JDBC ... no more hardcode users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        //tell spring security to use JDBC authentication with our data source
        //and spring security knows that it's using a predefined table schema so spring
        //security will look in a table called Users and another table called roles


        return new JdbcUserDetailsManager(dataSource);
    }
    */

    //here if i want to add my own custom table for security
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
        //define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?"
        );
        //define query to retrieve the authorization/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,role from roles where user_id=?"
        );

        return jdbcUserDetailsManager;
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(configuer ->
                configuer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );
        //use http basic authentication
        http.httpBasic(Customizer.withDefaults());
        //disable Cross Site Request Forgery (csrf)
        //in general , not required for stateless REST API that use POST,GET,PUT,DELETE or PATCH
        http.csrf(csrf ->csrf.disable());
        return http.build();

    }

     
}
