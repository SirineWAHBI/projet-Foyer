package tn.esprit.tpfoyer1.services;

import tn.esprit.tpfoyer1.dto.ChambreDTO;

import java.util.List;

public interface IChambreService {

    ChambreDTO addChambre(ChambreDTO dto);

    List<ChambreDTO> getAllChambres();

    ChambreDTO getChambreById(Long id);

    void deleteChambre(Long id);

    ChambreDTO updateChambre(ChambreDTO dto);
}