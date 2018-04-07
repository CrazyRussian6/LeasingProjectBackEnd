package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.VehicleLeasingService;
/*<<<<<<< HEAD
=======*/
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.EndPoints;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
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

/*<<<<<<< HEAD
    @RequestMapping(value = "/vehicleLeasings")
=======*/
    @RequestMapping(value = EndPoints.VEHICLE_LEASINGS, method = RequestMethod.GET)
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
    public List<VehicleLeasingResponse> getAllVehicleLeasings() {
        return vehicleLeasingService.getAllVehicleLeasings();
    }

/*<<<<<<< HEAD
    @RequestMapping(value = "/vehicleLeasings/add", method = RequestMethod.POST)
=======*/
    @RequestMapping(value = EndPoints.VEHICLE_LEASINGS_ADD, method = RequestMethod.POST)
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
    public VehicleLeasingResponse addVehicleLeasing(@Valid @RequestBody VehicleLeasing vehicleLeasing) {
        return new VehicleLeasingResponse(vehicleLeasingService.addNewVehicleLeasing(vehicleLeasing));
    }

/*<<<<<<< HEAD
    @RequestMapping(value = "/vehicleLeasings/{id}")
    public List<VehicleLeasingResponse> getAllVehicleLeasingsByID(@PathVariable("id") String id){
        return vehicleLeasingService.findVehicleLeasingsByCustomerID(id);
    }
=======*/
    @RequestMapping(value = EndPoints.VEHICLE_LEASINGS_ID, method = RequestMethod.GET)
    public List<VehicleLeasing> getAllVehicleLeasingsByID(@PathVariable("id") String id){
        return vehicleLeasingService.findVehicleLeasingsByCustomerID(id);
    }

    @RequestMapping(value = EndPoints.VEHICLE_LEASINGS_UPDATESTATUS_ID, method = RequestMethod.PUT)
    public VehicleLeasing updateVehicleLeasingStatus(@PathVariable("id") String id,
                                                     @Valid @RequestBody VehicleLeasing leasing){
        return vehicleLeasingService.updateVehicleLeasingStatus(id, leasing);
    }
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
}
