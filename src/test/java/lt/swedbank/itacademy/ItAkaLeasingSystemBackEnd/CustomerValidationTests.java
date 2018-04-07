package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
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
public class CustomerValidationTests {

    private static Validator validator;
    private static Customer testCustomer;

    @Before
    public void setUp(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        initCustomer();
    }

    private void initCustomer(){
        Customer customer = new Customer();
        customer.setEmail("correct.email@gmail.com");
        customer.setAddress("non empty address");
        customer.setPhoneNumber(new BigInteger("860123456"));
        testCustomer = customer;
    }

    @Test
    public void CustomerEmailFormatTest(){
        //testCustomer.setEmail("oaskdaodkaoskdadsokasd");
        Set<ConstraintViolation<Customer>> violations = validator.validate(testCustomer);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void CustomerEmailNonNullTest(){
        //testCustomer.setEmail(null);
        Set<ConstraintViolation<Customer>> violations = validator.validate(testCustomer);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void CustomerAddressNonNullTest(){
        //testCustomer.setAddress(null);
        Set<ConstraintViolation<Customer>> violations = validator.validate(testCustomer);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void CustomerPhoneNumberNonNullTest(){
        //testCustomer.setPhoneNumber(null);
        Set<ConstraintViolation<Customer>> violations = validator.validate(testCustomer);
        assertTrue(violations.isEmpty());
    }
}
