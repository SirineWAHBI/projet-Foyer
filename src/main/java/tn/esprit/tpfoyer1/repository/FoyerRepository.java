package tn.esprit.tpfoyer1.repository;

import tn.esprit.tpfoyer1.entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {
}
