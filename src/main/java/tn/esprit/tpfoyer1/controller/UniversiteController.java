package tn.esprit.tpfoyer1.controller;

import tn.esprit.tpfoyer1.entity.Universite;
import tn.esprit.tpfoyer1.services.IUniversiteService;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer1.dto.UniversiteDTO;

import java.util.List;

@RestController
@RequestMapping("/universites")
public class UniversiteController {

    private final IUniversiteService universiteService;

    public UniversiteController(IUniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    @PostMapping
    public Universite addUniversite(@RequestBody UniversiteDTO dto) {
        return universiteService.addUniversite(dto);
    }

    @PutMapping
    public Universite updateUniversite(@RequestBody UniversiteDTO dto) {
        return universiteService.updateUniversite(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
    }

    @GetMapping("/{id}")
    public Universite getUniversiteById(@PathVariable Long id) {
        return universiteService.getUniversiteById(id);
    }

    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversites();
    }
}