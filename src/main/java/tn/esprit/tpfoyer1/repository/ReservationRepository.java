package tn.esprit.tpfoyer1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer1.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
