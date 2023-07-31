package springBoot.exoRecette.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "categorie",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Recette> recette;

    public Categorie() {
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

    public List<Recette> getRecettes() {
        return recette;
    }

    public void setRecettes(List<Recette> recette) {
        this.recette = recette;
    }


}
