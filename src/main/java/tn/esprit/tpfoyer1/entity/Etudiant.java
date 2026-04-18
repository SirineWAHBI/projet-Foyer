package tn.esprit.tpfoyer1.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "etudiant")
@Getter          // ← add this
@Setter          // ← add this
@NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    private String nomEt;
    private String prenomEt;
    private Long cin;
    private String ecole;

    private LocalDate dateNaissance;

    @ManyToMany(mappedBy = "etudiants")
    @JsonIgnore
    private Set<Reservation> reservations;
}
