package at.fh.ima.swengs.rentacar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Amar on 12.01.2017.
 */

/**
 * http://docs.spring.io/spring-data/rest/docs/current/reference/html/
 */
@RepositoryRestResource
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    //This would be exposed under the URL: http://localhost:8080/customers/search/findByFirstNameAndLastName?firstName="NAME"&lastName="NAME"
    public List<Customer> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName")String lastName);

}


/**
 * Is needed for the Customers which implements UserDetailService in order to search for customer by email!
 */

@Repository
interface CustomerRepository2 extends CrudRepository<Customer, Long> {
    Customer findByEmail(String email);
}