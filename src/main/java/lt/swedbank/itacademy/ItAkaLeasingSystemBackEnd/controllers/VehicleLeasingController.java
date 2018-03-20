package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.VehicleLeasingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Lukas on 2018-03-20.
 */
@RestController
@CrossOrigin
@RequestMapping("/")
public class VehicleLeasingController {

    @Autowired
    private VehicleLeasingService vehicleLeasingService;

    @RequestMapping("/vehicleLeasings")
    public List<VehicleLeasingResponse> getAllVehicleLeasings() {
        return vehicleLeasingService.getAllVehicleLeasings();
    }

    @RequestMapping("/vehicleLeasings/add")
    public VehicleLeasingResponse addVehicleLeasing(@Valid @RequestBody VehicleLeasing vehicleLeasing) {
        return new VehicleLeasingResponse(vehicleLeasingService.addNewVehicleLeasing(vehicleLeasing));
    }
}
