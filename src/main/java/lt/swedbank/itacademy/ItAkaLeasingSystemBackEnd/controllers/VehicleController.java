package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Vehicle;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.VehicleService;
/*<<<<<<< HEAD
=======*/
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.EndPoints;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/")
public class VehicleController {

    @Autowired
/*<<<<<<< HEAD

    private VehicleService vehicleService;

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
=======*/
    private VehicleService vehicleService;

    @RequestMapping(value = EndPoints.VEHICLES, method = RequestMethod.GET)
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
    public List<VehicleResponse> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

/*<<<<<<< HEAD
    @RequestMapping(value = "/vehicles/add", method = RequestMethod.POST)
=======*/
    @RequestMapping(value = EndPoints.VEHICLES_ADD, method = RequestMethod.POST)
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
    public VehicleResponse addVehicle(@Valid @RequestBody Vehicle vehicle){
        return new VehicleResponse(vehicleService.addNewVehicle(vehicle));
    }
}
