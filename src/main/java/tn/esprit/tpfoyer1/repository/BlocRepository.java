package tn.esprit.tpfoyer1.repository;

import tn.esprit.tpfoyer1.entity.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
}
