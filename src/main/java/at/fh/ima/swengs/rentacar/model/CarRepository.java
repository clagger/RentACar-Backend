package at.fh.ima.swengs.rentacar.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Amar on 12.01.2017.
 */
@RepositoryRestResource
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {

    //This would be exposed under localhost:8080/cars/search/findByBrand?brand="BRANDNAME"
    public List<Car> findByBrand(@Param("brand") String brand);

    public List<Car> findByModel(@Param("model") String model);

    public List<Car> findBySeatNumber(@Param("seatNumber") int seatNumber);

    public List<Car> findByGasType(@Param("gasType") String gasType);

    public List<Car> findByTransmission(@Param("transmission") String transmission);

    @Query(value = "SELECT c.* from car c JOIN rented_car rc on c.id = rc.id WHERE rc.customer_id = ?1", nativeQuery = true)
    public List<Car> findByCustomer(@Param("customer") int customer);
}
