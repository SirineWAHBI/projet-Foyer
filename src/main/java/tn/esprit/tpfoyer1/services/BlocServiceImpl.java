package tn.esprit.tpfoyer1.services;

import tn.esprit.tpfoyer1.dto.BlocDTO;
import tn.esprit.tpfoyer1.entity.Bloc;
import tn.esprit.tpfoyer1.entity.Foyer;
import tn.esprit.tpfoyer1.mapper.BlocMapper;
import tn.esprit.tpfoyer1.repository.BlocRepository;
import tn.esprit.tpfoyer1.repository.FoyerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlocServiceImpl implements IBlocService {

    private final BlocRepository blocRepository;
    private final FoyerRepository foyerRepository;
    private final BlocMapper mapper;

    public BlocServiceImpl(BlocRepository blocRepository,
                           FoyerRepository foyerRepository,
                           BlocMapper mapper) {
        this.blocRepository = blocRepository;
        this.foyerRepository = foyerRepository;
        this.mapper = mapper;
    }

    @Override
    public BlocDTO addBloc(BlocDTO dto) {

        Bloc bloc = mapper.toEntity(dto);

        Foyer foyer = foyerRepository.findById(dto.getFoyerId())
                .orElseThrow(() -> new RuntimeException("Foyer introuvable"));

        bloc.setFoyer(foyer);

        return mapper.toDTO(blocRepository.save(bloc));
    }

    @Override
    public BlocDTO updateBloc(BlocDTO dto) {

        Bloc bloc = blocRepository.findById(dto.getIdBloc())
                .orElseThrow(() -> new RuntimeException("Bloc introuvable"));

        bloc.setNomBloc(dto.getNomBloc());
        bloc.setCapaciteBloc(dto.getCapaciteBloc());

        Foyer foyer = foyerRepository.findById(dto.getFoyerId())
                .orElseThrow(() -> new RuntimeException("Foyer introuvable"));

        bloc.setFoyer(foyer);

        return mapper.toDTO(blocRepository.save(bloc));
    }

    @Override
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public BlocDTO getBlocById(Long id) {
        return blocRepository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<BlocDTO> getAllBlocs() {
        return blocRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}