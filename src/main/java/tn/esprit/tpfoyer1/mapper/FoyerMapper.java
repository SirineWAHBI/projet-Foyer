package tn.esprit.tpfoyer1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.tpfoyer1.dto.FoyerDTO;
import tn.esprit.tpfoyer1.entity.Foyer;

@Mapper(componentModel = "spring")
public interface FoyerMapper {

    @Mapping(source = "universite.idUniversite", target = "universiteId")
    FoyerDTO toDTO(Foyer foyer);

    @Mapping(target = "universite", ignore = true)
    @Mapping(target = "blocs", ignore = true)
    Foyer toEntity(FoyerDTO dto);
}