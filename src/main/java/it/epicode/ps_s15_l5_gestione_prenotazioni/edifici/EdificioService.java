package it.epicode.ps_s15_l5_gestione_prenotazioni.edifici;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {
    @Autowired
    EdificioRepository edificioRepository;
    @Autowired
    private Faker faker;

    public void createData() {
        for (int i = 0; i < 10; i++) {
            Edificio edificio = new Edificio();
            edificio.setNome("Edificio " + faker.name().lastName());
            edificio.setIndirizzo(faker.address().streetAddress());
            edificio.setCitta(faker.address().cityName());

            edificioRepository.save(edificio);
        }
    }

    public List<Edificio>FindAll() {
        return edificioRepository.findAll();
    }
    public Edificio createEdificio(String nome, String indirizzo, String citta) {
        Edificio edificio = new Edificio();
        edificio.setNome(nome);
        edificio.setIndirizzo(indirizzo);
        edificio.setCitta(citta);
        edificioRepository.save(edificio);
        return edificio;
    }
}
