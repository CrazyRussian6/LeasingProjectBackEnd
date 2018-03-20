package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.VehicleLeasingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * Created by Lukas on 2018-03-20.
 */
@Service
public class VehicleLeasingService {

    @Autowired
    private VehicleLeasingRepository vehicleLeasingRepository;

    public VehicleLeasing addNewVehicleLeasing(@Valid VehicleLeasing vehicleLeasing){
        VehicleLeasing newVehicleLeasing = new VehicleLeasing();

        return vehicleLeasingRepository.save(newVehicleLeasing);
    }
}
