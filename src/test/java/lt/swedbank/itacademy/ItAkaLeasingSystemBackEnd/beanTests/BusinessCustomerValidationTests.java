package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beanTests;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.CustomerType;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * @author Lukas
 */
public class BusinessCustomerValidationTests {

    private static Validator validator;
    private BusinessCustomer testCustomer;

    @Before
    public void setUp(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        initBusinessCustomer();
    }

    private void initBusinessCustomer(){
        BusinessCustomer customer = new BusinessCustomer();
        customer.setEmail("correct.email@gmail.com");
        customer.setAddress("non empty address");
        customer.setPhoneNumber(new BigInteger("860158722"));
        customer.setCompanyName("Swedbank");
        customer.setCompanyID("12345");
        customer.setCountry("testistan");
        customer.setCustomerType(CustomerType.BUSINESS);
        testCustomer = customer;
    }

    @Test
    public void BusinessCustomerCompanyNameNonNullTest(){
        testCustomer.setCompanyName(null);
        Set<ConstraintViolation<Customer>> violations = validator.validate(testCustomer);
        assertEquals(1, violations.size());
    }

    @Test
    public void BusinessCustomerCompanyIDNonNullTest(){
        testCustomer.setCompanyID(null);
        Set<ConstraintViolation<Customer>> violations = validator.validate(testCustomer);
        assertEquals(1, violations.size());
    }
}
