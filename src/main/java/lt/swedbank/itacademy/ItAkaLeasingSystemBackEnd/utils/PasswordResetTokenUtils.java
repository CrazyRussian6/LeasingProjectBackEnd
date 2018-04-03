package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.tokens.PasswordResetToken;

import java.util.Calendar;
import java.util.Date;

public class PasswordResetTokenUtils {

    public static String validate(PasswordResetToken token){
        if(token == null){
            return "null token";
        }
        Calendar cal = Calendar.getInstance();
        if((token.getExpirationDate().getTime() - cal.getTime().getTime()) < 0){
            return "expired";
        }
        return "valid";
    }
}
