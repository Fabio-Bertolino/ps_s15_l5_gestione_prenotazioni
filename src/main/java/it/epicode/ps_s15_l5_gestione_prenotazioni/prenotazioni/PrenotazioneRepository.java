package it.epicode.ps_s15_l5_gestione_prenotazioni.prenotazioni;

import it.epicode.ps_s15_l5_gestione_prenotazioni.postazioni.Postazione;
import it.epicode.ps_s15_l5_gestione_prenotazioni.utenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);
    List<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);
}
