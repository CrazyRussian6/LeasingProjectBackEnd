package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.VehicleLeasingService;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.EndPoints;
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

    @RequestMapping(value = EndPoints.VEHICLE_LEASINGS, method = RequestMethod.GET)
    public List<VehicleLeasingResponse> getAllVehicleLeasings() {
        return vehicleLeasingService.getAllVehicleLeasings();
    }

    @RequestMapping(value = EndPoints.VEHICLE_LEASINGS_ADD, method = RequestMethod.POST)
    public VehicleLeasingResponse addVehicleLeasing(@Valid @RequestBody VehicleLeasing vehicleLeasing) {
        return new VehicleLeasingResponse(vehicleLeasingService.addNewVehicleLeasing(vehicleLeasing));
    }

    @RequestMapping(value = EndPoints.VEHICLE_LEASINGS_ID, method = RequestMethod.GET)
    public List<VehicleLeasing> getAllVehicleLeasingsByID(@PathVariable("id") String id){
        return vehicleLeasingService.findVehicleLeasingsByCustomerID(id);
    }

    @RequestMapping(value = EndPoints.VEHICLE_LEASINGS_UPDATESTATUS_ID, method = RequestMethod.PUT)
    public VehicleLeasing updateVehicleLeasingStatus(@PathVariable("id") String id,
                                                     @Valid @RequestBody VehicleLeasing leasing){
        return vehicleLeasingService.updateVehicleLeasingStatus(id, leasing);
    }
}
