package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils;

import java.security.SecureRandom;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserIDGenerator {

    private static final String feed = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();

    public static String generateRandomID(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(feed.charAt(rnd.nextInt(feed.length())));
        return sb.toString();
    }
}
