package tn.esprit.tpfoyer1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "foyer")
@Getter          // ← add this
@Setter          // ← add this
@NoArgsConstructor
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    private String nomFoyer;
    private Long capaciteFoyer;
    @OneToOne(mappedBy = "foyer")
    @JsonIgnore
    private Universite universite;

    @OneToMany(mappedBy = "foyer")
    @JsonIgnore
    private Set<Bloc> blocs;
}
