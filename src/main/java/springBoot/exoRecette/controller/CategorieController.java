package springBoot.exoRecette.controller;

import org.springframework.web.bind.annotation.*;
import springBoot.exoRecette.model.Categorie;
import springBoot.exoRecette.service.CategorieService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/all")
    public List<Categorie> findAll() {
        return categorieService.findAll();
    }

    @PostMapping("/add")
    public Categorie save(@RequestBody Categorie categorie) {
        return categorieService.save(categorie);
    }

    @GetMapping("/{id}")
    public Categorie findById(@PathVariable Long id) {
        return categorieService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        categorieService.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        categorieService.deleteAll();
    }

    @PatchMapping("/update")
    public Categorie update(@RequestBody Categorie categorie) {
        return categorieService.update(categorie);
    }

    @PatchMapping("/update2/{id}")
    public Categorie update2(@RequestBody Categorie categorie, @PathVariable Long id) {
        categorie.setId(id);
        return categorieService.update2(categorie);
    }

}
