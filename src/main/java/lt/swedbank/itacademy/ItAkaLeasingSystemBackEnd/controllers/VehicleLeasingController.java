package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.VehicleLeasingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Lukas on 2018-03-20.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/")
public class VehicleLeasingController {

    @Autowired
    private VehicleLeasingService vehicleLeasingService;

    @RequestMapping(value = "/vehicleLeasings")
    public List<VehicleLeasingResponse> getAllVehicleLeasings() {
        return vehicleLeasingService.getAllVehicleLeasings();
    }

    @RequestMapping(value = "/vehicleLeasings/add", method = RequestMethod.POST)
    public VehicleLeasingResponse addVehicleLeasing(@Valid @RequestBody VehicleLeasing vehicleLeasing) {
        return new VehicleLeasingResponse(vehicleLeasingService.addNewVehicleLeasing(vehicleLeasing));
    }
}
