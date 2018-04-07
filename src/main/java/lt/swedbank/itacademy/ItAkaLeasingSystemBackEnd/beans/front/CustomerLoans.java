package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;

import java.util.List;

public class CustomerLoans {

    private Customer customer;
    private List<VehicleLeasing> leasings;

    public CustomerLoans() {
    }

    public CustomerLoans(Customer customer, List<VehicleLeasing> leasings) {
        this.customer = customer;
        this.leasings = leasings;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<VehicleLeasing> getLeasings() {
        return leasings;
    }

    public void setLeasings(List<VehicleLeasing> leasings) {
        this.leasings = leasings;
    }
}
