package at.fh.ima.swengs.rentacar.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Amar on 12.01.2017.
 */

@RepositoryRestResource()
public interface RentedCarRepository  extends PagingAndSortingRepository<RentedCar, Long> {

    @Query(value= "SELECT id FROM rented_car "
            + "where customer_id = ?1 and car_id = ?2",nativeQuery=true)
    public int findRentedCar( @Param("customer") int customer,@Param("car") int car);


}

