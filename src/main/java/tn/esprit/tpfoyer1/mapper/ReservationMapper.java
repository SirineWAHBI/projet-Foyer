package tn.esprit.tpfoyer1.mapper;

import org.mapstruct.*;
import tn.esprit.tpfoyer1.dto.ReservationDTO;
import tn.esprit.tpfoyer1.entity.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    // Entity → DTO
    @Mapping(target = "chambreIds", ignore = true)
    @Mapping(target = "etudiantIds", ignore = true)
    ReservationDTO toDTO(Reservation reservation);

    // DTO → Entity
    @Mapping(target = "chambres", ignore = true)
    @Mapping(target = "etudiants", ignore = true)
    Reservation toEntity(ReservationDTO dto);
}