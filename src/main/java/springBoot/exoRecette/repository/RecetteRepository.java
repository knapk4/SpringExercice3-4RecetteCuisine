package springBoot.exoRecette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springBoot.exoRecette.model.Recette;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Long> {
}
