package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.tokens.PasswordResetToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResetTokenRepository extends CrudRepository<PasswordResetToken, Long> {

    List<PasswordResetToken> findAll();

    PasswordResetToken findByToken(String token);

    PasswordResetToken findByCustomerID(String customerID);
}
