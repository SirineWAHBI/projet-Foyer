package tn.esprit.tpfoyer1.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "reservation")
@Getter          // ← add this
@Setter          // ← add this
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // This is the modern Spring Boot 3 / Jakarta way
    private String idReservation;

    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;

    private Boolean estValide;

    @ManyToMany

    private Set<Chambre> chambres;

    @ManyToMany
    private Set<Etudiant> etudiants;
}
