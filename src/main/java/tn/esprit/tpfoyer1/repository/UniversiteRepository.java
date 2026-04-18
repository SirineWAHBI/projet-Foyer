package tn.esprit.tpfoyer1.repository;

import tn.esprit.tpfoyer1.entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
}
