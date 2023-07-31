package springBoot.exoRecette.service;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springBoot.exoRecette.model.Categorie;
import springBoot.exoRecette.model.Ingredient;
import springBoot.exoRecette.repository.CategorieRepository;
import java.util.List;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    private final JdbcTemplate jdbcTemplate;

    public CategorieService(CategorieRepository categorieRepository, JdbcTemplate jdbcTemplate) {
        this.categorieRepository = categorieRepository;
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Categorie> findAll(){
        return categorieRepository.findAll();
    }

    public Categorie save(Categorie categorie){
        return categorieRepository.save(categorie);
    }

    public Categorie findById(Long id){
        return categorieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categorie not found"));
    }

    public void deleteById(Long id) {
        categorieRepository.deleteById(id);
    }

    public void deleteAll() {
        categorieRepository.deleteAll();
    }

    public Categorie update(Categorie categorie) {
        if(categorie.getId() == null) {
            categorieRepository.save(categorie);
        }else {
            jdbcTemplate.update("UPDATE categorie SET name = ? WHERE id = ?",
                    categorie.getName(), categorie.getId());
        }
        return categorie;
    }

    public Categorie update2(Categorie categorie) {
          categorieRepository.updateCategorie(categorie.getName(), categorie.getId());
          return categorie;
    }
}
