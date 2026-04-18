package tn.esprit.tpfoyer1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer1.dto.ReservationDTO;
import tn.esprit.tpfoyer1.entity.Reservation;
import tn.esprit.tpfoyer1.mapper.ReservationMapper;
import tn.esprit.tpfoyer1.services.IReservationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    private IReservationService reservationService;
    private ReservationMapper reservationMapper;

    @PostMapping("/add")
    public ReservationDTO addReservation(@RequestBody ReservationDTO dto) {
        Reservation reservation = reservationMapper.toEntity(dto);
        Reservation saved = reservationService.addReservation(reservation);
        return reservationMapper.toDTO(saved);
    }

    @GetMapping("/all")
    public List<ReservationDTO> getAllReservations() {
        return reservationService.getAllReservations()
                .stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReservationDTO getReservationById(@PathVariable String id) {
        return reservationMapper.toDTO(
                reservationService.getReservationById(id)
        );
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable String id) {
        reservationService.deleteReservation(id);
    }

    @PutMapping("/update")
    public ReservationDTO updateReservation(@RequestBody ReservationDTO dto) {
        Reservation reservation = reservationMapper.toEntity(dto);
        Reservation updated = reservationService.updateReservation(reservation);
        return reservationMapper.toDTO(updated);
    }
}