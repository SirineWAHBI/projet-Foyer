package tn.esprit.tpfoyer1.services;

import tn.esprit.tpfoyer1.dto.UniversiteDTO;
import tn.esprit.tpfoyer1.entity.Foyer;
import tn.esprit.tpfoyer1.entity.Universite;
import tn.esprit.tpfoyer1.repository.FoyerRepository;
import tn.esprit.tpfoyer1.repository.UniversiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {

    private final UniversiteRepository universiteRepository;
    private final FoyerRepository foyerRepository;

    public UniversiteServiceImpl(UniversiteRepository universiteRepository,
                                 FoyerRepository foyerRepository) {
        this.universiteRepository = universiteRepository;
        this.foyerRepository = foyerRepository;
    }

    @Override
    public Universite addUniversite(UniversiteDTO dto) {
        Universite u = mapToEntity(dto);
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(UniversiteDTO dto) {
        Universite u = universiteRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Universite not found"));

        u.setNomUniversite(dto.getNomUniversite());
        u.setAdresse(dto.getAdresse());

        if (dto.getFoyerId() != null) {
            Foyer foyer = foyerRepository.findById(dto.getFoyerId())
                    .orElseThrow(() -> new RuntimeException("Foyer not found"));
            u.setFoyer(foyer);
        }

        return universiteRepository.save(u);
    }

    @Override
    public void deleteUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite getUniversiteById(Long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    // 🔥 Méthode de mapping propre
    private Universite mapToEntity(UniversiteDTO dto) {
        Universite u = new Universite();
        u.setNomUniversite(dto.getNomUniversite());
        u.setAdresse(dto.getAdresse());

        if (dto.getFoyerId() != null) {
            Foyer foyer = foyerRepository.findById(dto.getFoyerId())
                    .orElseThrow(() -> new RuntimeException("Foyer not found"));
            u.setFoyer(foyer);
        }

        return u;
    }
}