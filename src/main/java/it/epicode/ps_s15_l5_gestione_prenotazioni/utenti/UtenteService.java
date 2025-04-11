package it.epicode.ps_s15_l5_gestione_prenotazioni.utenti;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private Faker faker;

    public void createData() {
        for (int i = 0; i < 10; i++) {
            Utente utente = new Utente();
            utente.setUsername(faker.name().username());
            utente.setNomeCompleto(faker.name().fullName());
            utente.setEmail(faker.internet().emailAddress());
            utenteRepository.save(utente);
        }
    }
    public List<Utente>FindAll(){
        return utenteRepository.findAll();
    }
}
