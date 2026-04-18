package tn.esprit.tpfoyer1.services;

import tn.esprit.tpfoyer1.dto.FoyerDTO;

import java.util.List;

public interface IFoyerService {

    FoyerDTO addFoyer(FoyerDTO dto);

    FoyerDTO updateFoyer(FoyerDTO dto);

    void deleteFoyer(Long id);

    FoyerDTO getFoyerById(Long id);

    List<FoyerDTO> getAllFoyers();
}