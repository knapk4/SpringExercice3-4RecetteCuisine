package springBoot.exoRecette.controller;

import org.springframework.web.bind.annotation.*;
import springBoot.exoRecette.model.IngredientQuantite;
import springBoot.exoRecette.service.IngredientQuantiteService;

import java.util.List;

@RestController
@RequestMapping("/ingredientQuantites")
public class IngredientQuantiteController {

    // On ajoute un attribut ingredientsQuantiteService
    private final IngredientQuantiteService ingredientQuantiteService;

    // On instancie un objet ingredientsQuantiteService
    public IngredientQuantiteController(IngredientQuantiteService ingredientQuantiteService) {
        this.ingredientQuantiteService = ingredientQuantiteService;
    }


    @GetMapping("/all")
    public List<IngredientQuantite> findAll() {
        return ingredientQuantiteService.findAll();
    }

    @PostMapping("/add")
    public IngredientQuantite save(@RequestBody IngredientQuantite ingredientQuantite) {
        return ingredientQuantiteService.save(ingredientQuantite);
    }

    @GetMapping("/{id}")
    public IngredientQuantite findById(@PathVariable Long id) {
        return ingredientQuantiteService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        ingredientQuantiteService.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        ingredientQuantiteService.deleteAll();
    }

    @PatchMapping("/update")
    public IngredientQuantite update(@RequestBody IngredientQuantite ingredientQuantite) {
        return ingredientQuantiteService.update(ingredientQuantite);
    }
}
