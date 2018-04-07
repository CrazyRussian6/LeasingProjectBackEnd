package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beanTests;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Administrator;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.AdministratorType;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

public class AdministratorValidationTests {

    private static Validator validator;
    private static Set<ConstraintViolation<Administrator>> violations;
    private Administrator testAdministrator;

    @Before
    public void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        initTestAdministrator();
    }

    private void initTestAdministrator() {
        this.testAdministrator = new Administrator();
        testAdministrator.setId(new ObjectId());
        testAdministrator.setUserID("adminID");
        testAdministrator.setPassword("encryptedSafeAdminPassword");
        testAdministrator.setAdministratorType(AdministratorType.LEASING_OFFICER);
    }

    private void assertValidator(){
        assertEquals(1, validator.validate(testAdministrator).size());
    }

    @Test
    public void administratorObjectIDValueTest() {
        ObjectId testId = new ObjectId();
        testAdministrator.setId(testId);
        assertEquals(testAdministrator.getId(), testId);
    }

    @Test
    public void administratorLoginIDNotNullTest() {
        testAdministrator.setUserID(null);
        assertValidator();
    }

    @Test
    public void administratorPasswordNotNullTest() {
        testAdministrator.setPassword(null);
        assertValidator();
    }
}
