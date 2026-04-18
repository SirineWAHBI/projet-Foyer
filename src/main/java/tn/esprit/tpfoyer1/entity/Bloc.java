package tn.esprit.tpfoyer1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "T_bloc")
@Getter          // ← add this
@Setter          // ← add this
@NoArgsConstructor
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    private String nomBloc;
    private Long capaciteBloc;
    @ManyToOne
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    private Set<Chambre> chambres;

}
