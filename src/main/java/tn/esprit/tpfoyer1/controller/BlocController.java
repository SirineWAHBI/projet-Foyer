package tn.esprit.tpfoyer1.controller;

import tn.esprit.tpfoyer1.dto.BlocDTO;
import tn.esprit.tpfoyer1.services.IBlocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blocs")
public class BlocController {

    private final IBlocService blocService;

    public BlocController(IBlocService blocService) {
        this.blocService = blocService;
    }

    @PostMapping
    public BlocDTO addBloc(@RequestBody BlocDTO dto) {
        return blocService.addBloc(dto);
    }

    @PutMapping
    public BlocDTO updateBloc(@RequestBody BlocDTO dto) {
        return blocService.updateBloc(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteBloc(@PathVariable Long id) {
        blocService.deleteBloc(id);
    }

    @GetMapping("/{id}")
    public BlocDTO getBlocById(@PathVariable Long id) {
        return blocService.getBlocById(id);
    }

    @GetMapping
    public List<BlocDTO> getAllBlocs() {
        return blocService.getAllBlocs();
    }
}