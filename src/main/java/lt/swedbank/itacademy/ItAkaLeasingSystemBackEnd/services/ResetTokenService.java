package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.tokens.PasswordResetToken;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.ResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class ResetTokenService {

    @Autowired
    ResetTokenRepository repository;

    public List<PasswordResetToken> findAllTokens(){
        return repository.findAll();
    }

    public void addToken(@Valid PasswordResetToken token){
        repository.save(token);
    }

    public PasswordResetToken findByToken(String token){
        return repository.findByToken(token);
    }

    public void deleteByToken(String token){
        repository.delete(repository.findByToken(token));
    }

    public PasswordResetToken findByCustomerID(String customerID){
        return repository.findByCustomerID(customerID);
    }

    public void deleteToken(String customerID){
        repository.delete(repository.findByCustomerID(customerID));
    }
}
