package tn.esprit.tpfoyer1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer1.entity.Chambre;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}