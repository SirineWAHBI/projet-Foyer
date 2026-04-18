package tn.esprit.tpfoyer1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.tpfoyer1.dto.BlocDTO;
import tn.esprit.tpfoyer1.entity.Bloc;

@Mapper(componentModel = "spring")
public interface BlocMapper {

    @Mapping(source = "foyer.idFoyer", target = "foyerId")
    BlocDTO toDTO(Bloc bloc);

    @Mapping(target = "foyer", ignore = true)
    @Mapping(target = "chambres", ignore = true)
    Bloc toEntity(BlocDTO dto);
}