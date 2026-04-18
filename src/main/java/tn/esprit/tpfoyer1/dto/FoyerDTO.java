package tn.esprit.tpfoyer1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoyerDTO {

    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;

    // relation université
    private Long universiteId;
}