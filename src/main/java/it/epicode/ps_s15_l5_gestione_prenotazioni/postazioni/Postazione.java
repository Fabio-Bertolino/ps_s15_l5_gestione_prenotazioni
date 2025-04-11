package it.epicode.ps_s15_l5_gestione_prenotazioni.postazioni;

import it.epicode.ps_s15_l5_gestione_prenotazioni.edifici.Edificio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "postazioni")
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 200)
    private String descrizione;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "tipo_postazione")
    private TipoPostazione tipoPostazione;
    @Column(nullable = false, name = "numero_posti_max")
    private Integer numeroPostiMax;
    @ManyToOne
    private Edificio edificio;
}
