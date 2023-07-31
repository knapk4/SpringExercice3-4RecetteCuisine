package springBoot.exoRecette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springBoot.exoRecette.model.IngredientQuantite;

@Repository
public interface IngredientQuantiteRepository extends JpaRepository<IngredientQuantite, Long>{
}
