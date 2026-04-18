package tn.esprit.tpfoyer1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.tpfoyer1.dto.ChambreDTO;
import tn.esprit.tpfoyer1.entity.Chambre;

@Mapper(componentModel = "spring")
public interface ChambreMapper {

    @Mapping(source = "bloc.idBloc", target = "blocId")
    ChambreDTO toDTO(Chambre chambre);

    @Mapping(target = "bloc", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Chambre toEntity(ChambreDTO dto);
}