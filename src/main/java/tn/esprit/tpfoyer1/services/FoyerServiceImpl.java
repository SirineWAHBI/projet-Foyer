package tn.esprit.tpfoyer1.services;

import tn.esprit.tpfoyer1.dto.FoyerDTO;
import tn.esprit.tpfoyer1.entity.Foyer;
import tn.esprit.tpfoyer1.entity.Universite;
import tn.esprit.tpfoyer1.mapper.FoyerMapper;
import tn.esprit.tpfoyer1.repository.FoyerRepository;
import tn.esprit.tpfoyer1.repository.UniversiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoyerServiceImpl implements IFoyerService {

    private final FoyerRepository foyerRepository;
    private final UniversiteRepository universiteRepository;
    private final FoyerMapper mapper;

    public FoyerServiceImpl(FoyerRepository foyerRepository,
                            UniversiteRepository universiteRepository,
                            FoyerMapper mapper) {
        this.foyerRepository = foyerRepository;
        this.universiteRepository = universiteRepository;
        this.mapper = mapper;
    }

    @Override
    public FoyerDTO addFoyer(FoyerDTO dto) {

        Foyer foyer = mapper.toEntity(dto);

        if (dto.getUniversiteId() != null) {
            Universite universite = universiteRepository.findById(dto.getUniversiteId())
                    .orElseThrow(() -> new RuntimeException("Université introuvable"));

            foyer.setUniversite(universite);
        }

        return mapper.toDTO(foyerRepository.save(foyer));
    }

    @Override
    public FoyerDTO updateFoyer(FoyerDTO dto) {

        Foyer foyer = foyerRepository.findById(dto.getIdFoyer())
                .orElseThrow(() -> new RuntimeException("Foyer introuvable"));

        foyer.setNomFoyer(dto.getNomFoyer());
        foyer.setCapaciteFoyer(dto.getCapaciteFoyer());

        if (dto.getUniversiteId() != null) {
            Universite universite = universiteRepository.findById(dto.getUniversiteId())
                    .orElseThrow(() -> new RuntimeException("Université introuvable"));

            foyer.setUniversite(universite);
        }

        return mapper.toDTO(foyerRepository.save(foyer));
    }

    @Override
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public FoyerDTO getFoyerById(Long id) {
        return foyerRepository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<FoyerDTO> getAllFoyers() {
        return foyerRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}