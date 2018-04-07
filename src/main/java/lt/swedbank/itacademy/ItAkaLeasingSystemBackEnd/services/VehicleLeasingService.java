package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

/*<<<<<<< HEAD
=======*/
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.VehicleLeasingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*<<<<<<< HEAD
=======*/
import org.springframework.web.bind.annotation.RequestBody;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
/*<<<<<<< HEAD
=======*/
import java.util.Optional;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6

@Service
public class VehicleLeasingService {

    @Autowired
    private VehicleLeasingRepository vehicleLeasingRepository;

/*<<<<<<< HEAD
=======*/
    @Autowired
    private CustomerService customerService;

//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
    public VehicleLeasing addNewVehicleLeasing(@Valid VehicleLeasing vehicleLeasing) {
        VehicleLeasing newVehicleLeasing = new VehicleLeasing();

        newVehicleLeasing.setEnginePower(vehicleLeasing.getEnginePower());
        newVehicleLeasing.setManufacturer(vehicleLeasing.getManufacturer());
        newVehicleLeasing.setManufacturingDate(vehicleLeasing.getManufacturingDate());
        newVehicleLeasing.setModel(vehicleLeasing.getModel());
        newVehicleLeasing.setAdvancePaymentAmount(vehicleLeasing.getAdvancePaymentAmount());
        newVehicleLeasing.setAdvancePaymentPercent(vehicleLeasing.getAdvancePaymentPercent());
        newVehicleLeasing.setAssetPrice(vehicleLeasing.getAssetPrice());
        newVehicleLeasing.setContractFee(vehicleLeasing.getContractFee());
        newVehicleLeasing.setMargin(vehicleLeasing.getMargin());
        newVehicleLeasing.setLeasingPeriod(vehicleLeasing.getLeasingPeriod());
        newVehicleLeasing.setPaymentDate(vehicleLeasing.getPaymentDate());

        newVehicleLeasing.setCustomerID(vehicleLeasing.getCustomerID());

        newVehicleLeasing.setSubmissionDate(vehicleLeasing.getSubmissionDate());
        newVehicleLeasing.setLeasingStatus(vehicleLeasing.getLeasingStatus());

        return vehicleLeasingRepository.save(newVehicleLeasing);
    }

    public List<VehicleLeasingResponse> getAllVehicleLeasings() {
        List<VehicleLeasingResponse> responses = new ArrayList<>();
        for (VehicleLeasing vehicleLeasing : vehicleLeasingRepository.findAll()) {
            responses.add(new VehicleLeasingResponse(vehicleLeasing));
        }
        return responses;
    }

/*<<<<<<< HEAD
    public List<VehicleLeasingResponse> findVehicleLeasingsByCustomerID(String customerID) {
        List<VehicleLeasingResponse> responses = new ArrayList<>();
        for (VehicleLeasing vehicleLeasing : vehicleLeasingRepository.findVehicleLeasingsByCustomerID(customerID)) {
            responses.add(new VehicleLeasingResponse(vehicleLeasing));
        }
        return responses;
=======*/
    public List<VehicleLeasing> findVehicleLeasingsByCustomerID(String customerID) {
        Customer customer = customerService.findCustomerByUserID(customerID);
        return vehicleLeasingRepository.findVehicleLeasingsByCustomerID(customer.getId().toString());
    }

    public VehicleLeasing updateVehicleLeasingStatus(String leasingId, @Valid @RequestBody VehicleLeasing leasing){
        Optional<VehicleLeasing> optional = vehicleLeasingRepository.findVehicleLeasingById(leasingId);
        if(optional.isPresent()){
            optional.get().setLeasingStatus(leasing.getLeasingStatus());
            return vehicleLeasingRepository.save(optional.get());
        }
        else{
            return null;
        }
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
    }
}
