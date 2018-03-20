package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.VehicleLeasingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Lukas on 2018-03-20.
 */
public class VehicleLeasingController {

    @Autowired
    private VehicleLeasingService vehicleLeasingService;

    //@RequestMapping("")
    public List<VehicleLeasingResponse> getAllVehicleLeasings() {
        return vehicleLeasingService.getAllVehicleLeasings();
    }

    //@RequestMapping("")
    public VehicleLeasingResponse addVehicleLeasing(@Valid @RequestBody VehicleLeasing vehicleLeasing) {
        return new VehicleLeasingResponse(vehicleLeasingService.addNewVehicleLeasing(vehicleLeasing));
    }
}
