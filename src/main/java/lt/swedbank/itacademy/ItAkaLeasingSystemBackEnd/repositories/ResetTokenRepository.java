package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.tokens.PasswordResetToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResetTokenRepository extends CrudRepository<PasswordResetToken, Long> {

    List<PasswordResetToken> findAll();

    Optional<PasswordResetToken> findByToken(String token);

    Optional<PasswordResetToken> findByCustomerID(String customerID);
}
