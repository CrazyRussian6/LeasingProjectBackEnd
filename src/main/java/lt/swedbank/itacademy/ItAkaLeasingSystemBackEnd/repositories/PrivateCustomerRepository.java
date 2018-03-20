package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Lukas on 2018-03-20.
 */
public interface PrivateCustomerRepository extends CrudRepository<PrivateCustomer, String> {

    List<PrivateCustomer> findAll();
}
