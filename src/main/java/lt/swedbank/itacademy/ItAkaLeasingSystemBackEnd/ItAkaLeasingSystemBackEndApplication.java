package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.LeasingStatus;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.config.JwtFilter;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.EndPoints;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ItAkaLeasingSystemBackEndApplication {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns(EndPoints.PROTECTED_ENDPOINTS);
        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(ItAkaLeasingSystemBackEndApplication.class, args);
    }
}
