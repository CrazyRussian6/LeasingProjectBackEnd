package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beanTests;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.CustomerType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigInteger;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Lukas
 */
@RunWith(value = BlockJUnit4ClassRunner.class)
public class PrivateCustomerValidationTests {

    private static Validator validator;
    private PrivateCustomer testCustomer;

    @Before
    public void setUp(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        initPrivateCustomer();
    }

    private void initPrivateCustomer(){
        PrivateCustomer customer = new PrivateCustomer();
        customer.setEmail("correct.email@gmail.com");
        customer.setAddress("non empty address");
        customer.setPhoneNumber(new BigInteger("860123456"));
        customer.setFirstName("First name");
        customer.setLastName("Last name");
        customer.setPrivateID("12345678901");
        customer.setCountry("testistan");
        customer.setCustomerType(CustomerType.PRIVATE);
        testCustomer = customer;
    }

    @Test
    public void PrivateCustomerFirstNameNonNullTest(){
        testCustomer.setFirstName(null);
        Set<ConstraintViolation<Customer>> violations = validator.validate(testCustomer);
        assertEquals(violations.size(), 1);
    }

    @Test
    public void PrivateCustomerLastNameNonNullTest(){
        testCustomer.setLastName(null);
        Set<ConstraintViolation<Customer>> violations = validator.validate(testCustomer);
        assertEquals(violations.size(),1 );
    }

    @Test
    public void PrivateCustomerPrivateIDNonNullTest(){
        testCustomer.setPrivateID(null);
        Set<ConstraintViolation<Customer>> violations = validator.validate(testCustomer);
        assertEquals(violations.size(),1 );
    }

    @Test
    public void PrivateCustomerPrivateIDIsNumericTest(){
        testCustomer.setPrivateID("1234567890x");
        Set<ConstraintViolation<Customer>> violations = validator.validate(testCustomer);
        assertEquals(1, violations.size());
    }
}
