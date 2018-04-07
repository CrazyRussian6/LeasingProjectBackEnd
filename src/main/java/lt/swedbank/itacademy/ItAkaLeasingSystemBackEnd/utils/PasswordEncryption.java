package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryption {

    public static String encrypt(String identifier, String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(identifier+password);
    }

    public static boolean decrypt(String formIdentifier, String formPassword, String dbData){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(formIdentifier+formPassword, dbData);
    }
}
