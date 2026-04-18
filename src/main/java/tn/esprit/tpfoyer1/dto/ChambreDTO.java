package tn.esprit.tpfoyer1.dto;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.tpfoyer1.entity.TypeChambre;

@Getter
@Setter
public class ChambreDTO {

    private Long idChambre;
    private String nomChambre;
    private long numeroChambre;
    private TypeChambre typeC;

    private Long blocId;
}