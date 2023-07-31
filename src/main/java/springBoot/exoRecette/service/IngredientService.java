package springBoot.exoRecette.service;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springBoot.exoRecette.model.Ingredient;
import springBoot.exoRecette.repository.IngredientRepository;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    private final JdbcTemplate jdbcTemplate;

    public IngredientService(IngredientRepository ingredientRepository,JdbcTemplate jdbcTemplate) {
        this.ingredientRepository = ingredientRepository;
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found"));
    }

    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient update(Ingredient ingredient) {
        if(ingredient.getId() == null) {
            ingredientRepository.save(ingredient);
        }else {
            jdbcTemplate.update("UPDATE ingredient SET name = ? WHERE id = ?",
                    ingredient.getName(), ingredient.getId());
        }
        return ingredient;
    }

    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }

    public void deleteAll() {
        ingredientRepository.deleteAll();
    }


}
