package tn.esprit.tpfoyer1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer1.dto.ChambreDTO;
import tn.esprit.tpfoyer1.services.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {

    private IChambreService chambreService;

    @PostMapping("/add")
    public ChambreDTO addChambre(@RequestBody ChambreDTO dto) {
        return chambreService.addChambre(dto);
    }

    @GetMapping("/all")
    public List<ChambreDTO> getAllChambres() {
        return chambreService.getAllChambres();
    }

    @GetMapping("/{id}")
    public ChambreDTO getChambre(@PathVariable Long id) {
        return chambreService.getChambreById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChambre(@PathVariable Long id) {
        chambreService.deleteChambre(id);
    }

    @PutMapping("/update")
    public ChambreDTO updateChambre(@RequestBody ChambreDTO dto) {
        return chambreService.updateChambre(dto);
    }
}