package springBoot.exoRecette.controller;

import org.springframework.web.bind.annotation.*;
import springBoot.exoRecette.model.Recette;
import springBoot.exoRecette.service.RecetteService;

import java.util.List;

@RestController
@RequestMapping("/recettes")
public class RecetteController {

    private final RecetteService recetteService;

    public RecetteController(RecetteService recetteService) {
        this.recetteService = recetteService;
    }

    @PostMapping("/add")
    public Recette save(@RequestBody Recette recette) {
        return recetteService.save(recette);
    }

    @GetMapping("/all")
    public List<Recette> findAll() {
        return recetteService.findAll();
    }


    @GetMapping("/{id}")
    public Recette findById(@PathVariable Long id) {
        return recetteService.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        recetteService.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        recetteService.deleteAll();
    }

}
