package it.epicode.ps_s15_l5_gestione_prenotazioni.prenotazioni;

import com.github.javafaker.Faker;
import it.epicode.ps_s15_l5_gestione_prenotazioni.postazioni.Postazione;
import it.epicode.ps_s15_l5_gestione_prenotazioni.postazioni.PostazioneRepository;
import it.epicode.ps_s15_l5_gestione_prenotazioni.utenti.Utente;
import it.epicode.ps_s15_l5_gestione_prenotazioni.utenti.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private Faker faker;

    public void createPrenotazione(Utente utente, Postazione postazione) {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        prenotazione.setDataPrenotazione(LocalDate.now());
        prenotazione.setScadenzaPrenotazione(LocalDate.now().plusDays(1));
        prenotazioneRepository.save(prenotazione);

    }

}
