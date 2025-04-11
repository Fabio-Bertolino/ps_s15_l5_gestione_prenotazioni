package it.epicode.ps_s15_l5_gestione_prenotazioni.postazioni;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
List<Postazione> findByTipoPostazioneAndEdificio_Citta(TipoPostazione tipoPostazione, String citta);
}
