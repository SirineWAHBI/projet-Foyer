package tn.esprit.tpfoyer1.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer1.dto.ChambreDTO;
import tn.esprit.tpfoyer1.entity.Bloc;
import tn.esprit.tpfoyer1.entity.Chambre;
import tn.esprit.tpfoyer1.mapper.ChambreMapper;
import tn.esprit.tpfoyer1.repository.BlocRepository;
import tn.esprit.tpfoyer1.repository.ChambreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {

    private ChambreRepository chambreRepository;
    private BlocRepository blocRepository;
    private ChambreMapper mapper;

    @Override
    public ChambreDTO addChambre(ChambreDTO dto) {

        Chambre chambre = mapper.toEntity(dto);

        Bloc bloc = blocRepository.findById(dto.getBlocId())
                .orElseThrow(() -> new RuntimeException("Bloc introuvable"));

        chambre.setBloc(bloc);

        return mapper.toDTO(chambreRepository.save(chambre));
    }

    @Override
    public List<ChambreDTO> getAllChambres() {
        return chambreRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ChambreDTO getChambreById(Long id) {
        return chambreRepository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public ChambreDTO updateChambre(ChambreDTO dto) {

        Chambre chambre = chambreRepository.findById(dto.getIdChambre())
                .orElseThrow(() -> new RuntimeException("Chambre introuvable"));

        chambre.setNomChambre(dto.getNomChambre());
        chambre.setNumeroChambre(dto.getNumeroChambre());
        chambre.setTypeC(dto.getTypeC());

        Bloc bloc = blocRepository.findById(dto.getBlocId())
                .orElseThrow(() -> new RuntimeException("Bloc introuvable"));

        chambre.setBloc(bloc);

        return mapper.toDTO(chambreRepository.save(chambre));
    }
}