package at.fh.ima.swengs.rentacar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RentACarBackendApplication {


    public static void main(String[] args) {

        SpringApplication.run(RentACarBackendApplication.class, args);

    }

}


//TODO: Change grantType from password to implicit (use access token in header)
//TODO: See Class 'Customers' => change when someone gets ROLE_ADMIN (e.g. if endsWith is not good solution)
