package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, String> {

    List<Administrator> findAll();


    Optional<Administrator> findAdministratorByUserID(String userID);

}
