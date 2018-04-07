package utilsTests;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.PasswordEncryption;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.PasswordResetTokenUtils;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;

public class UtilsTests {

    @Test
    public void encryptionValidityTest(){
        String userName = "Tester";
        String password = "supersafetestingpassword123";
        String encrypted = PasswordEncryption.encrypt(userName, password);
        assertTrue(PasswordEncryption.decrypt(userName, password, encrypted));
    }
}
