package tn.esprit.tpfoyer1.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer1.dto.ChambreDTO;
import tn.esprit.tpfoyer1.entity.Bloc;
import tn.esprit.tpfoyer1.entity.Chambre;
import tn.esprit.tpfoyer1.entity.TypeChambre;
import tn.esprit.tpfoyer1.mapper.ChambreMapper;
import tn.esprit.tpfoyer1.repository.BlocRepository;
import tn.esprit.tpfoyer1.repository.ChambreRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {

    private ChambreRepository chambreRepository;
    private BlocRepository blocRepository;
    private ChambreMapper mapper;
    private static final Logger log = LoggerFactory.getLogger(ChambreServiceImpl.class);

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

    // ========================= SERVICE 01 =========================
    // Afficher chambres par bloc chaque 1 min

    @Scheduled(fixedRate = 60000)
    @Transactional
    public void listeChambresParBloc() {

        List<Bloc> blocs = blocRepository.findAll();

        for (Bloc bloc : blocs) {

            log.info("Bloc => {} ayant une capacite {}",
                    bloc.getNomBloc(), bloc.getCapaciteBloc());

            if (bloc.getChambres() == null || bloc.getChambres().isEmpty()) {

                log.info("Pas de chambre disponible dans ce bloc");

            } else {

                log.info("La liste des chambres pour ce bloc :");

                for (Chambre c : bloc.getChambres()) {
                    log.info("NumChambre: {} type: {}",
                            c.getNumeroChambre(), c.getTypeC());
                }
            }

            log.info("*****");
        }
    }

    // ========================= SERVICE 02 =========================
    // Pourcentage des chambres par type

    @Scheduled(fixedRate = 300000)
    public void pourcentageChambreParTypeChambre() {

        List<Chambre> chambres = chambreRepository.findAll();

        int total = chambres.size();

        log.info("Nombre total des chambres: {}", total);
        if (total == 0) return;
        long simple = chambres.stream()
                .filter(c -> c.getTypeC() == TypeChambre.SIMPLE)
                .count();
        long doub = chambres.stream()
                .filter(c -> c.getTypeC() == TypeChambre.DOUBLE)
                .count();
        long triple = chambres.stream()
                .filter(c -> c.getTypeC() == TypeChambre.TRIPLE)
                .count();

        log.info("Le pourcentage des chambres pour le type SIMPLE est égale à {}",
                simple * 100.0 / total);
        log.info("Le pourcentage des chambres pour le type DOUBLE est égale à {}",
                doub * 100.0 / total);
        log.info("Le pourcentage des chambres pour le type TRIPLE est égale à {}",
                triple * 100.0 / total);
    }

    // ========================= SERVICE 03 =========================
    // Nombre de places disponibles par chambre

    @Scheduled(fixedRate = 300000)
    @Transactional
    public void nbPlacesDisponibleParChambreAnneeEnCours() {

        List<Chambre> chambres = chambreRepository.findAll();

        for (Chambre c : chambres) {

            int max = switch (c.getTypeC()) {
                case SIMPLE -> 1;
                case DOUBLE -> 2;
                case TRIPLE -> 3;
            };

            int occupe = (c.getReservations() != null)
                    ? c.getReservations().size()
                    : 0;
            int dispo = max - occupe;
            if (dispo <= 0) {

                log.info("La chambre {} {} est complete",
                        c.getTypeC(), c.getNumeroChambre());
            } else {
                log.info("Le nombre de place disponible pour la chambre {} {} est {}",
                        c.getTypeC(), c.getNumeroChambre(), dispo);
            }
        }
    }
}