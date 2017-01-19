package at.fh.ima.swengs.rentacar.model;

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


}

