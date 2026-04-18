package tn.esprit.tpfoyer1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class ReservationDTO {

    private String idReservation;
    private Date anneeUniversitaire;
    private Boolean estValide;

    private Set<Long> chambreIds;
    private Set<Long> etudiantIds;
}