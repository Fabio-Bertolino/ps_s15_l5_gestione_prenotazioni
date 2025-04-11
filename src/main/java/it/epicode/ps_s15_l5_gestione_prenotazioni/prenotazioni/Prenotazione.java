package it.epicode.ps_s15_l5_gestione_prenotazioni.prenotazioni;

import it.epicode.ps_s15_l5_gestione_prenotazioni.postazioni.Postazione;
import it.epicode.ps_s15_l5_gestione_prenotazioni.utenti.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Utente utente;
    @ManyToOne
    private Postazione postazione;
    @Column(nullable = false, name = "data_prenotazione")
    private LocalDate dataPrenotazione;
    @Column(name = "scadenza_prenotazione")
    private LocalDate scadenzaPrenotazione = null;
}
