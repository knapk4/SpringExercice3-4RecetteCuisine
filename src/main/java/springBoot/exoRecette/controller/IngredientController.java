package springBoot.exoRecette.controller;

import org.springframework.web.bind.annotation.*;
import springBoot.exoRecette.model.Ingredient;
import springBoot.exoRecette.service.IngredientService;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/all")
    public List<Ingredient> findAll() {
        return ingredientService.findAll();
    }

    @GetMapping("/{id}")
    public Ingredient findById(@PathVariable Long id) {
        return ingredientService.findById(id);
    }

    @PostMapping("/add")
    public Ingredient save(@RequestBody Ingredient ingredient) {
        return ingredientService.save(ingredient);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        ingredientService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        ingredientService.deleteById(id);
    }

    @PatchMapping("/update")
    public Ingredient update(@RequestBody Ingredient ingredient) {
        return ingredientService.update(ingredient);
    }
}
