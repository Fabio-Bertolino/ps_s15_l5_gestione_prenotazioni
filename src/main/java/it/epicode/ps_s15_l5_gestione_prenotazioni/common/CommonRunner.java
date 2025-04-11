package it.epicode.ps_s15_l5_gestione_prenotazioni.common;


import it.epicode.ps_s15_l5_gestione_prenotazioni.edifici.Edificio;
import it.epicode.ps_s15_l5_gestione_prenotazioni.edifici.EdificioRepository;
import it.epicode.ps_s15_l5_gestione_prenotazioni.edifici.EdificioService;
import it.epicode.ps_s15_l5_gestione_prenotazioni.postazioni.Postazione;
import it.epicode.ps_s15_l5_gestione_prenotazioni.postazioni.PostazioneRepository;
import it.epicode.ps_s15_l5_gestione_prenotazioni.postazioni.PostazioneService;
import it.epicode.ps_s15_l5_gestione_prenotazioni.postazioni.TipoPostazione;
import it.epicode.ps_s15_l5_gestione_prenotazioni.prenotazioni.PrenotazioneRepository;
import it.epicode.ps_s15_l5_gestione_prenotazioni.prenotazioni.PrenotazioneService;
import it.epicode.ps_s15_l5_gestione_prenotazioni.utenti.UtenteRepository;
import it.epicode.ps_s15_l5_gestione_prenotazioni.utenti.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CommonRunner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private EdificioRepository edificioRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Override
    public void run(String... args) throws Exception {
        edificioService.createData();
        postazioneService.createData();
        utenteService.createData();

        Edificio edificio = edificioService.createEdificio("Edificio TEST", "Via TEST", "Benedetta del friuli");
        Edificio edificio2 = edificioService.createEdificio("Edificio TEST 2", "Via TEST 2", "Benedetta del friuli");
        Postazione postazione = postazioneService.createPostazione("Postazione TEST", TipoPostazione.OPENSPACE , 1, edificio);
        Postazione postazione2= postazioneService.createPostazione("Postazione TEST 2", TipoPostazione.OPENSPACE , 30, edificio2);

        System.out.println("--------------------------------------------------");
        System.out.println("=-=-=-=-=-=-=-=-= PROVA TEST QUERY =-=-=-=-=-=-=-=");
        System.out.println("--------------------------------------------------");
        System.out.println("Postazioni OPENSPACE in Benedetta del friuli: ");
        postazioneRepository.findByTipoPostazioneAndEdificio_Citta(TipoPostazione.OPENSPACE, "Benedetta del friuli").forEach(e -> System.out.println(e.getId() + " - " + e.getDescrizione() + " - " + e.getTipoPostazione() + " - " + e.getEdificio().getIndirizzo() + " (" + e.getEdificio().getCitta() + ")"));

        System.out.println("--------------------------------------------------");
        System.out.println("=-=-=-=-=-=-=-=-= PROVA PRENOTAZIONI =-=-=-=-=-=-=-=");
        System.out.println("--------------------------------------------------");
        prenotazioneService.createPrenotazione(utenteRepository.findById(1L).get(), postazione, LocalDate.now());
        prenotazioneService.createPrenotazione(utenteRepository.findById(1L).get(), postazione2, LocalDate.of(2025, 4, 23));
        prenotazioneService.createPrenotazione(utenteRepository.findById(1L).get(), postazione2, LocalDate.now());
        prenotazioneService.createPrenotazione(utenteRepository.findById(2L).get(), postazione, LocalDate.now());
    }

}
