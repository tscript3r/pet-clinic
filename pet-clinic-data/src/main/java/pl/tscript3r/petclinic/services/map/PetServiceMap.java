package pl.tscript3r.petclinic.services.map;

import org.springframework.stereotype.Service;
import pl.tscript3r.petclinic.models.Pet;
import pl.tscript3r.petclinic.services.PetService;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractServiceMap<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
