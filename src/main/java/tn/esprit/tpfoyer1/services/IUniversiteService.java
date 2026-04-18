package tn.esprit.tpfoyer1.services;

import tn.esprit.tpfoyer1.dto.UniversiteDTO;
import tn.esprit.tpfoyer1.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(UniversiteDTO dto);
    Universite updateUniversite(UniversiteDTO dto);
    void deleteUniversite(Long idUniversite);
    Universite getUniversiteById(Long idUniversite);
    List<Universite> getAllUniversites();
}