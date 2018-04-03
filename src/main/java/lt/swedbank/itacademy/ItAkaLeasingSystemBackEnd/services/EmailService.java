package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.tokens.PasswordResetToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendEmail(SimpleMailMessage message){
        mailSender.send(message);
    }

    public boolean validTimePassed(PasswordResetToken passwordResetToken, int timeoutMinutes){
        Date lastSendDate = passwordResetToken.getSendTime();

        Calendar calendar = Calendar.getInstance();
        long testVal = (calendar.getTime().getTime() - lastSendDate.getTime())/1000/60;
        System.out.println(testVal);
        return testVal >= timeoutMinutes;
    }
}
