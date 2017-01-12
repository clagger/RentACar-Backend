package at.fh.ima.swengs.rentacar.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Amar on 12.01.2017.
 */

/**
 * http://docs.spring.io/spring-data/rest/docs/current/reference/html/
 */
@RepositoryRestResource
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    //This would be exposed under the URL: http://localhost:8080/customers/search/findByFirstNameAndLastName
    public List<Customer> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName")String lastName);

}

