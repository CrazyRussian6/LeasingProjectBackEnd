package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleLeasingRepository extends CrudRepository<VehicleLeasing, String> {

    List<VehicleLeasing> findAll();
    List<VehicleLeasing> findVehicleLeasingsByCustomerID(String customerID);
    Optional<VehicleLeasing> findVehicleLeasingById(String id);
}
