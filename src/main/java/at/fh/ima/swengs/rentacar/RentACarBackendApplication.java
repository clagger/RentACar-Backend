package at.fh.ima.swengs.rentacar;

import at.fh.ima.swengs.rentacar.model.CarRepository;
import at.fh.ima.swengs.rentacar.model.CustomerRepository;
import at.fh.ima.swengs.rentacar.model.RentedCarRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class RentACarBackendApplication {

	@Autowired
	CustomerRepository Customers;

	@Autowired
	CarRepository Cars;

	@Autowired
	RentedCarRepository RentedCars;


	public static void main(String[] args) {

		SpringApplication.run(RentACarBackendApplication.class, args);
	}



	@Configuration
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	@EnableWebSecurity
	static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

		/**
		 * This section defines the user accounts which can be used for authentication as well as the roles each user has.
		 *
		 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
		 */
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			auth.inMemoryAuthentication().//
					withUser("user").password("user").roles("USER").and().//
					withUser("admin").password("admin").roles("ADMIN", "USER");
		}

		/**
		 * This section defines the security policy for the app.
		 * <p>
		 * <ul>
		 * <li>BASIC authentication is supported (enough for this REST-based demo).</li>
		 * <li>/employees is secured using URL security shown below.</li>
		 * <li>CSRF headers are disabled since we are only testing the REST interface, not a web one.</li>
		 * </ul>
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
		}
	}
}