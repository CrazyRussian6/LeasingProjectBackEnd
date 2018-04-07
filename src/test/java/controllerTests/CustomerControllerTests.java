package controllerTests;


import com.fasterxml.jackson.databind.ObjectMapper;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.CustomerType;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.BusinessCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.CustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.PrivateCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers.CustomerController;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.CustomerService;
import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.mockito.Mockito.*;

@WebAppConfiguration
public class CustomerControllerTests {

    @Autowired
    private MockMvc mvc;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private BusinessCustomer testBusinessCustomer;
    private PrivateCustomer testPrivateCustomer;

    private BusinessCustomerResponse testBusinessCustomerResponse;
    private PrivateCustomerResponse testPrivateCustomerResponse;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getCustomersTest() throws Exception {
        List<CustomerResponse> customers = new ArrayList<>();

        customers.add(testBusinessCustomerResponse);
        customers.add(testPrivateCustomerResponse);

        when(customerService.getAllCustomers()).thenReturn(customers);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/customers")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();

        verify(customerService, times(1)).getAllCustomers();

        List<LinkedHashMap> returnList = mapper.readValue(content, ArrayList.class);
        BusinessCustomerResponse returnedBusinessCustomerResponse =
                mapper.readValue(new JSONObject(returnList.get(0)).toString(), BusinessCustomerResponse.class);
        PrivateCustomerResponse returnedPrivateCustomerResponse =
                mapper.readValue(new JSONObject(returnList.get(1)).toString(),
                        PrivateCustomerResponse.class);

        Assert.assertEquals(200, result.getResponse().getStatus());
        Assert.assertTrue("empty HTTP response body", content.trim().length() > 0);
        Assert.assertEquals(testPrivateCustomerResponse, returnedPrivateCustomerResponse);
        Assert.assertEquals(testBusinessCustomerResponse, returnedBusinessCustomerResponse);
    }

    @Test
    public void addBusinessCustomerTest() throws Exception {
        when(customerService.addNewBusinessCustomer(testBusinessCustomer))
                .thenReturn(testBusinessCustomer);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/customers/addBusinessCustomer")
                .content(mapper.writeValueAsString(testBusinessCustomer))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        String testBusinessCustomerJSON = mapper.writeValueAsString(testBusinessCustomerResponse);

        Assert.assertEquals(200, result.getResponse().getStatus());
        Assert.assertTrue("empty HTTP response body", content.trim().length() > 0);
        Assert.assertEquals(testBusinessCustomerJSON, content);
    }

    @Test
    public void addPrivateCustomerTest() throws Exception {
        when(customerService.addNewPrivateCustomer(testPrivateCustomer))
                .thenReturn(testPrivateCustomer);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/customers/addPrivateCustomer")
                .content(mapper.writeValueAsString(testPrivateCustomer))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        String testPrivateCustomerJSON = mapper.writeValueAsString(testPrivateCustomerResponse);

        Assert.assertEquals(200, result.getResponse().getStatus());
        Assert.assertTrue("empty HTTP response body", content.trim().length() > 0);
        Assert.assertEquals(testPrivateCustomerJSON, content);
    }


    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(this.customerController).build();

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
        this.testBusinessCustomerResponse = new BusinessCustomerResponse(testBusinessCustomer);

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
        this.testPrivateCustomerResponse = new PrivateCustomerResponse(testPrivateCustomer);
    }
}
