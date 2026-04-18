package tn.esprit.tpfoyer1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UniversiteDTO {
    private Long id;
    private String nomUniversite;
    private String adresse;

    // 🔥 juste l'id du foyer
    private Long foyerId;
}
