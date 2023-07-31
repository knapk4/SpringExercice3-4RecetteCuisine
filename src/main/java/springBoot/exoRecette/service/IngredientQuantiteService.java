package springBoot.exoRecette.service;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springBoot.exoRecette.model.Ingredient;
import springBoot.exoRecette.model.IngredientQuantite;
import springBoot.exoRecette.repository.IngredientQuantiteRepository;

import java.util.List;

@Service
public class IngredientQuantiteService {

    private final IngredientQuantiteRepository ingredientQuantiteRepository;

    private final JdbcTemplate jdbcTemplate;


    public IngredientQuantiteService(IngredientQuantiteRepository ingredientQuantiteRepository, JdbcTemplate jdbcTemplate) {
        this.ingredientQuantiteRepository = ingredientQuantiteRepository;
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<IngredientQuantite> findAll(){
        return ingredientQuantiteRepository.findAll();
    }

    public IngredientQuantite save(IngredientQuantite ingredientQuantite){
        return ingredientQuantiteRepository.save(ingredientQuantite);
    }

    public IngredientQuantite findById(Long id){
        return ingredientQuantiteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "IngredientQuantite not found"));
    }

    public void deleteById(Long id) {
        ingredientQuantiteRepository.deleteById(id);
    }

    public void deleteAll() {
        ingredientQuantiteRepository.deleteAll();
    }

    public IngredientQuantite update(IngredientQuantite ingredientQuantite) {
        if (ingredientQuantite.getId() == null) {
            ingredientQuantiteRepository.save(ingredientQuantite);
        } else {
            jdbcTemplate.update("UPDATE ingredient_quantite SET quantite = ? WHERE id = ?",
                    ingredientQuantite.getQuantite(), ingredientQuantite.getId());

            Ingredient ingredient = ingredientQuantite.getIngredient();
            Long ingredientId = ingredient.getId();
            String currentName = jdbcTemplate.queryForObject(
                    "SELECT name FROM ingredient WHERE id = ?",
                    String.class,
                    ingredientId
            );

            if (!currentName.equals(ingredient.getName())) {
                jdbcTemplate.update("UPDATE ingredient SET name = ? WHERE id = ?",
                        ingredient.getName(), ingredientId);
            }
        }
        return ingredientQuantite;
    }
}
