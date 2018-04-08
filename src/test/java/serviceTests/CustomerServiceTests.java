package serviceTests;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.CustomerType;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.CustomerRepository;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.CustomerService;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class CustomerServiceTests {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository repository;

    private BusinessCustomer testBusinessCustomer;
    private PrivateCustomer testPrivateCustomer;

    @Test
    public void findCustomerByEmailTest() {
        when(repository.findCustomerByEmail("sample.email@email.com")).thenReturn(Optional.of(testBusinessCustomer));
        Assert.assertEquals(testBusinessCustomer, customerService.findCustomerByEmail("sample.email@email.com"));
    }

    @Test
    public void findCustomerByUserIDTest() {
        when(repository.findCustomerByEmail("tester.yahoo@email.com")).thenReturn(Optional.of(testPrivateCustomer));
        Assert.assertEquals(testPrivateCustomer, customerService.findCustomerByEmail("tester.yahoo@email.com"));
    }

    @Test
    public void existsCustomerByIDAndEmailTest() {
        when(repository.existsCustomerByUserIDAndEmail("sample.email@email.com", "ABCYYYA23654569"))
                .thenReturn(true);
        Assert.assertEquals(true,
                customerService.existsCustomerByUserIDAndEmail("sample.email@email.com", "ABCYYYA23654569"));

    }

    @Test
    public void existsBusinessCustomerTest() {
        List<Customer> returnList = new ArrayList<>();
        returnList.add(testBusinessCustomer);
        when(repository.findCustomersByCustomerType(CustomerType.BUSINESS)).thenReturn(returnList);
        Assert.assertEquals(testBusinessCustomer, customerService.ifExistsBusinessCustomer(
                testBusinessCustomer.getCompanyID(),
                testBusinessCustomer.getCompanyName()));
    }

    @Test
    public void existsPrivateCustomerTest() {
        List<Customer> returnList = new ArrayList<>();
        returnList.add(testPrivateCustomer);
        when(repository.findCustomersByCustomerType(CustomerType.PRIVATE)).thenReturn(returnList);
        Assert.assertEquals(testPrivateCustomer, customerService.ifExistsPrivateCustomer(
                testPrivateCustomer.getPrivateID(),
                testPrivateCustomer.getFirstName(),
                testPrivateCustomer.getLastName()));
    }


    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        this.testBusinessCustomer = new BusinessCustomer(
                new ObjectId(),
                "sample.email@email.com",
                new BigInteger("860157777"),
                "testPlace 32-64",
                CustomerType.BUSINESS,
                "testland",
                "ABCYYYA23654569",
                "ABCYYYA23654569",
                false,
                "1236666",
                "testCompany");

        this.testPrivateCustomer = new PrivateCustomer(
                new ObjectId(),
                "tester.yahoo@email.com",
                new BigInteger("86044444"),
                "somewhere",
                CustomerType.PRIVATE,
                "testland",
                "W1Z3A5A6W9W4",
                "WAOEAWEOKAWE",
                false,
                "6694112375",
                "testerName",
                "testerSurname");
    }
}
