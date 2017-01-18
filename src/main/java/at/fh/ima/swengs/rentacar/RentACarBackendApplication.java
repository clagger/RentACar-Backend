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

@SpringBootApplication
public class RentACarBackendApplication {


    public static void main(String[] args) {

        SpringApplication.run(RentACarBackendApplication.class, args);
    }

}