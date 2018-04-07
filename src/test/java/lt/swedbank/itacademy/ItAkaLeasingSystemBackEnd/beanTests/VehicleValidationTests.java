package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beanTests;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Vehicle;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigInteger;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class VehicleValidationTests {

    private static Validator validator;
    private static Vehicle vehicle;

    @Before
    public void setUp(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        initVehicle();
    }

    private void initVehicle(){
        vehicle = new Vehicle();
        vehicle.setId(new ObjectId());
        vehicle.setGroupValue("BUICK");
        vehicle.setText("Riviera");
        vehicle.setValue("Riviera");
    }

    @Test
    public void VehicleGroupValueNotNullTest(){
        vehicle.setGroupValue(null);
        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        assertEquals(1, violations.size());
    }

    @Test
    public void VehicleValueNotNullTest(){
        vehicle.setValue(null);
        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        assertEquals(1, violations.size());
    }

}
