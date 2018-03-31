package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigInteger;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;

/**
 * @author Lukas
 */
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
        testCustomer = customer;
    }

    @Test
    public void PrivateCustomerFirstNameNonNullTest(){
        //testCustomer.setFirstName(null);
        Set<ConstraintViolation<Customer>> violations = validator.validate(testCustomer);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void PrivateCustomerLastNameNonNullTest(){
        //testCustomer.setLastName(null);
        Set<ConstraintViolation<Customer>> violations = validator.validate(testCustomer);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void PrivateCustomerPrivateIDNonNullTest(){
        //testCustomer.setPrivateID(null);
        Set<ConstraintViolation<Customer>> violations = validator.validate(testCustomer);
        assertTrue(violations.isEmpty());
    }

    @Test(expected = NumberFormatException.class)
    public void PrivateCustomerPrivateIDIsNumericTest(){
        testCustomer.setPrivateID("1234567890x");
        BigInteger i = new BigInteger(testCustomer.getPrivateID());
        Set<ConstraintViolation<Customer>> violations = validator.validate(testCustomer);
        assertTrue(violations.isEmpty());
    }
}
