package tn.esprit.tpfoyer1.services;

import tn.esprit.tpfoyer1.entity.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation addReservation(Reservation reservation);

    List<Reservation> getAllReservations();

    Reservation getReservationById(String id);

    void deleteReservation(String id);

    Reservation updateReservation(Reservation reservation);
}
