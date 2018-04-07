package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Administrator;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.AdministratorResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.CustomerLoans;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.AdministratorResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.AdministratorRepository;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.CustomerRepository;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.VehicleLeasingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AdministratorService {

    @Autowired
    AdministratorRepository administratorRepository;


/*    public List<Administrator> getAllAdministrators(){
        return administratorRepository.findAll();
    }

    AdministratorResponse getAdministratorByID(String userID){
        return new AdministratorResponse(administratorRepository.findAdministratorByUserID(userID));
*/
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    VehicleLeasingRepository vehicleLeasingRepository;

    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    public AdministratorResponse getAdministratorByID(String userID) {
        Optional<Administrator> optional = administratorRepository.findAdministratorByUserID(userID);
        if (optional.isPresent()) {
            return new AdministratorResponse(optional.get());
        } else {
            return null;
        }
    }


    public List<CustomerLoans> getCustomerLoans() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerLoans> customerLoans = new ArrayList<>();
        for (Customer customer : customers) {
            List<VehicleLeasing> customerLeasings =
                    vehicleLeasingRepository.findVehicleLeasingsByCustomerID(customer.getId().toString());
            customerLoans.add(new CustomerLoans(customer, customerLeasings));
        }
        return customerLoans;

    }
}
