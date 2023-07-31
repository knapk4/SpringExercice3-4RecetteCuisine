package springBoot.exoRecette.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springBoot.exoRecette.model.Categorie;
@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {


    @Modifying
    @Transactional
    @Query("UPDATE Categorie c SET c.name = ?1 WHERE c.id = ?2")
    void updateCategorie(String name, Long id);

}
