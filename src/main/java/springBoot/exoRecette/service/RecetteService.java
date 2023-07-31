package springBoot.exoRecette.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springBoot.exoRecette.model.Recette;
import springBoot.exoRecette.repository.RecetteRepository;

import java.util.List;

@Service
public class RecetteService {

    private final RecetteRepository recetteRepository;

    public RecetteService(RecetteRepository recetteRepository) {
        this.recetteRepository = recetteRepository;
    }

    public List<Recette> findAll(){
        return recetteRepository.findAll();
    }

    public Recette save(Recette recette){
        return recetteRepository.save(recette);
    }

    public Recette findById(Long id){
        return recetteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recette not found"));
    }

    public void deleteById(Long id) {
        recetteRepository.deleteById(id);
    }

    public void deleteAll() {
        recetteRepository.deleteAll();
    }
}
