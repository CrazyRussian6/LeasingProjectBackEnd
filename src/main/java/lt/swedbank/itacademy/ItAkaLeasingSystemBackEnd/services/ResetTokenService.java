package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.tokens.PasswordResetToken;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.ResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
/*<<<<<<< HEAD
=======*/
import java.util.Optional;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6

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
/*<<<<<<< HEAD
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
=======*/
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
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
    }
}
