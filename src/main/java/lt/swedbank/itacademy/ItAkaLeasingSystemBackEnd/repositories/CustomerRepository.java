package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.CustomerType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Lukas
 */
public interface CustomerRepository extends CrudRepository<Customer, String>{

    List<Customer> findAll();

    List<Customer> findCustomersByCustomerType(CustomerType customerType);

    boolean existsCustomerByUserID(String userID);
}
