package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String> {

    List<Vehicle> findAll();
}
