package it.epicode.ps_s15_l5_gestione_prenotazioni.postazioni;

import com.github.javafaker.Faker;
import it.epicode.ps_s15_l5_gestione_prenotazioni.edifici.Edificio;
import it.epicode.ps_s15_l5_gestione_prenotazioni.edifici.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private Faker faker;
    @Autowired
    private EdificioRepository edificioRepository;

    public void createData() {
        for (int i = 0; i < 10; i++) {
            Postazione postazione = new Postazione();
            postazione.setDescrizione(faker.name().title());
            postazione.setTipoPostazione(TipoPostazione.values()[faker.number().numberBetween(0, 3)]);
            postazione.setNumeroPostiMax(faker.number().numberBetween(1, 50));
            postazione.setEdificio(edificioRepository.findById((long) faker.number().numberBetween(1, 10)).get());
            postazioneRepository.save(postazione);
        }
    }
    public List<Postazione>FindAll(){
        return postazioneRepository.findAll();
    }

    public Postazione createPostazione(String descrizione, TipoPostazione tipoPostazione, int numeroPostiMax, Edificio edificio) {
        Postazione postazione = new Postazione();
        postazione.setDescrizione(descrizione);
        postazione.setTipoPostazione(tipoPostazione);
        postazione.setNumeroPostiMax(numeroPostiMax);
        postazione.setEdificio(edificio);
        postazioneRepository.save(postazione);
        return postazione;
    }
}
