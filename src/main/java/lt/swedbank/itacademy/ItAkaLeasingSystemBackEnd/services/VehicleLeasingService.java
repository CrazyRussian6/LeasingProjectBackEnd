package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.VehicleLeasingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleLeasingService {

    @Autowired
    private VehicleLeasingRepository vehicleLeasingRepository;

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

    public List<VehicleLeasingResponse> findVehicleLeasingsByCustomerID(String customerID) {
        List<VehicleLeasingResponse> responses = new ArrayList<>();
        for (VehicleLeasing vehicleLeasing : vehicleLeasingRepository.findVehicleLeasingsByCustomerID(customerID)) {
            responses.add(new VehicleLeasingResponse(vehicleLeasing));
        }
        return responses;
    }
}
