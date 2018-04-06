package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.tokens.PasswordResetToken;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.ResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
        return repository.findByToken(token).orElse(null);
    }

    public void deleteByToken(String token){
        java.util.Optional<PasswordResetToken> optional = repository.findByToken(token);
        if(optional.isPresent()){
            repository.delete(optional.get());
        }
    }

    public PasswordResetToken findByCustomerID(String customerID){
        return repository.findByCustomerID(customerID).orElse(null);

    }

    public void deleteToken(String customerID){

        Optional<PasswordResetToken> optional = repository.findByCustomerID(customerID);
        if(optional.isPresent()){
            repository.delete(optional.get());
        }
    }
}
