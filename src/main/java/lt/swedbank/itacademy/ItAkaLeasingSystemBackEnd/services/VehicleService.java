package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Vehicle;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle addNewVehicle(@Valid Vehicle vehicle){
        Vehicle newVehicle = new Vehicle();
        newVehicle.setGroupValue(vehicle.getGroupValue());
        newVehicle.setValue(vehicle.getValue());
        newVehicle.setText(vehicle.getText());
        return vehicleRepository.save(vehicle);
    }

    public List<VehicleResponse> getAllVehicles(){
        List<VehicleResponse> responses = new ArrayList<>();
        for(Vehicle vehicle : vehicleRepository.findAll()){
            responses.add(new VehicleResponse(vehicle));
        }
        return responses;
    }
}
