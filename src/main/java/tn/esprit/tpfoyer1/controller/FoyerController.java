package tn.esprit.tpfoyer1.controller;

import tn.esprit.tpfoyer1.dto.FoyerDTO;
import tn.esprit.tpfoyer1.services.IFoyerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyers")
public class FoyerController {

    private final IFoyerService foyerService;

    public FoyerController(IFoyerService foyerService) {
        this.foyerService = foyerService;
    }

    @PostMapping
    public FoyerDTO addFoyer(@RequestBody FoyerDTO dto) {
        return foyerService.addFoyer(dto);
    }

    @PutMapping
    public FoyerDTO updateFoyer(@RequestBody FoyerDTO dto) {
        return foyerService.updateFoyer(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable Long id) {
        foyerService.deleteFoyer(id);
    }

    @GetMapping("/{id}")
    public FoyerDTO getFoyerById(@PathVariable Long id) {
        return foyerService.getFoyerById(id);
    }

    @GetMapping
    public List<FoyerDTO> getAllFoyers() {
        return foyerService.getAllFoyers();
    }
}