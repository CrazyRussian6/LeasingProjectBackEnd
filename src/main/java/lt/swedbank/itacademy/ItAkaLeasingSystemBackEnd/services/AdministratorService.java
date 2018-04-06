package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Administrator;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.AdministratorResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {

    @Autowired
    AdministratorRepository administratorRepository;

    public List<Administrator> getAllAdministrators(){
        return administratorRepository.findAll();
    }

    AdministratorResponse getAdministratorByID(String userID){
        Optional<Administrator> optional = administratorRepository.findAdministratorByUserID(userID);
        if(optional.isPresent()){
            return new AdministratorResponse(optional.get());
        }
        else{
            return null;
        }
    }
}
