package at.fh.ima.swengs.rentacar;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Amar on 13.01.2017.
 */

/*
 * Code taken from: https://github.com/spring-projects/spring-data-examples/tree/master/rest/security#writing-a-security-policy
 *
 * This file is responsible for serving BASIC HTTP Authentication.
 */


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * This section defines the user accounts which can be used for authentication as well as the roles each user has.
     *
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().//
                withUser("user").password("user").roles("USER").and().//
                withUser("admin").password("admin").roles("USER", "ADMIN");
    }

    /**
     * This section defines the security policy for the app.
     * BASIC authentication is supported (enough for this REST-based demo).
     * CSRF headers are disabled since we are only testing the REST interface, not a web one.
     *
     * NOTE: GET is not shown which defaults to permitted.
     *
     * @param http
     * @throws Exception
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic().and().authorizeRequests().
                antMatchers("/customers").hasRole("ADMIN").
                antMatchers("/customers/**").hasRole("ADMIN").
                antMatchers("/cars").hasRole("ADMIN").
                antMatchers("/cars/**").hasRole("ADMIN").
                antMatchers("/rentedCars").hasRole("ADMIN").
                antMatchers("/rentedCars/**").hasRole("ADMIN").
                antMatchers("/profile").hasRole("ADMIN")
                .and().
                csrf().disable();

                    /*Examples for HTTP Methods

                    .antMatchers(HttpMethod.POST, "/employees").hasRole("ADMIN")
                    .antMatchers(HttpMethod.PUT, "/employees/**").hasRole("ADMIN")
                    .antMatchers(HttpMethod.PATCH, "/employees/**").hasRole("ADMIN").and()

                    */
    }
}