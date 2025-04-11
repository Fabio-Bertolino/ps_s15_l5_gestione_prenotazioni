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

    public void createPrenotazione(Utente utente, Postazione postazione, LocalDate data) {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        prenotazione.setDataPrenotazione(data);
        prenotazione.setScadenzaPrenotazione(data.plusDays(1));
        System.out.println("L'utente: " + utente.getUsername() + " ha effettuato la prenotazione per la postazione: " + postazione.getId() + " in data: " + data);
        if (prenotazioneRepository.findByUtenteAndDataPrenotazione(utente, data).isEmpty()) {
            if (prenotazioneRepository.findByPostazioneAndDataPrenotazione(postazione, data).size() < postazione.getNumeroPostiMax()) {
            prenotazioneRepository.save(prenotazione);
            System.out.println("Prenotazione effettuata con successo!");
            System.out.println("Scadenza prenotazione: " + prenotazione.getScadenzaPrenotazione());
            System.out.println("--------------------------------------------------");
            } else {
                System.out.println("Prenotazione annullata: limite posti disponibili raggiunto per la data selezionata!");
                System.out.println("--------------------------------------------------");
            }
        }
        else {
            System.out.println("Prenotazione annullata: limite prenotazioni raggiunto per la data selezionata!");
            System.out.println("--------------------------------------------------");
        }
    }
}
