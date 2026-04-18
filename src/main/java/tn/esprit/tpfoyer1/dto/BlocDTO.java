package tn.esprit.tpfoyer1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlocDTO {

    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    private Long foyerId;
}