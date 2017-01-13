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


    public static void main(String[] args) {

        SpringApplication.run(RentACarBackendApplication.class, args);
    }

}