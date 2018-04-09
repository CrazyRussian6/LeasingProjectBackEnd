package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.CustomerType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String>{

    List<Customer> findAll();

    List<Customer> findCustomersByCustomerType(CustomerType customerType);

    boolean existsCustomerByUserID(String userID);

    Optional<Customer> findCustomerByUserID(String userID);

    boolean existsCustomerByEmail(String email);

    Optional<Customer> findCustomerByEmail(String email);


    boolean existsCustomerByUserIDAndEmail(String userID, String email);

}
