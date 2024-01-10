package com.luv2code.springboot.demosecurity.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    /*
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails john= User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails mary=User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails susan=User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(john,mary,susan);
    }
    */
    //----------------------------------------------------------------------------------

    //add support for jdbc
    /*
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        //tells spring security to use JDBC authentication with our data source
        return new JdbcUserDetailsManager(dataSource);

    }
*/
    // add support for JDBC ... no more hardcoded users :-)

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }



    //to config security of web paths in application,login,logout
    @Bean
    //this gonna pass in a hp security that can make use of
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        //restrict access based on the http request
        http.authorizeHttpRequests(configuer->
                configuer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()/*any request to the app
                 must be authenticated that mean is must logged in */
        )
                /* we are customizing the form here*/
                .formLogin(form->
                        form
                                .loginPage("/showMyLoginPage")/*specify the actual login page,we will show
                        our custom form for this given request mapping of /ShowMyLoginPage
                        */
                                .loginProcessingUrl("/authenticatedTheUser")
                                /* the login form will submit the data or post
                                the data to this Url for processing so we have authenticatedTheUser this
                                is where spring mvc will go through and check user and password
                                */
                                .permitAll() /*
                                allow everyone to see login page no need to be logged in
                                */
                )
                .logout(logout->logout.permitAll() //to add logout support for default url /logot

                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                );
                return http.build();
    }


}
