package springBoot.exoRecette.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private List<IngredientQuantite> ingredientQuantite;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "recette_categorie",
            joinColumns = @JoinColumn(name = "recette_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id")
    )
    @JsonBackReference
    private List<Categorie> categorie;
    public Recette() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<IngredientQuantite> getIngredientQuantite() {
        return ingredientQuantite;
    }

    public void setIngredientQuantite(List<IngredientQuantite> ingredientsQuantite) {
        this.ingredientQuantite = ingredientsQuantite;
    }

    public List<Categorie> getCategorie() {
        return categorie;
    }

    public void setCategorie(List<Categorie> categories) {
        this.categorie = categories;
    }


}
