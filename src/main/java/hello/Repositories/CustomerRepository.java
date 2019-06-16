package hello.Repositories;

import hello.Entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByLastName(String lastName);
    List<Customer> findAllByFirstName(String firstName);
}
