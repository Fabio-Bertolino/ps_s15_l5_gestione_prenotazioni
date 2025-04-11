package it.epicode.ps_s15_l5_gestione_prenotazioni.common;


import it.epicode.ps_s15_l5_gestione_prenotazioni.edifici.EdificioService;
import it.epicode.ps_s15_l5_gestione_prenotazioni.postazioni.PostazioneService;
import it.epicode.ps_s15_l5_gestione_prenotazioni.prenotazioni.PrenotazioneRepository;
import it.epicode.ps_s15_l5_gestione_prenotazioni.prenotazioni.PrenotazioneService;
import it.epicode.ps_s15_l5_gestione_prenotazioni.utenti.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommonRunner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Override
    public void run(String... args) throws Exception {
        edificioService.createData();
        postazioneService.createData();
        utenteService.createData();
    }

}
