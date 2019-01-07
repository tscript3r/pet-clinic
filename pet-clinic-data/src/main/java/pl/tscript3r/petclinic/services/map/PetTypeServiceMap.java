package pl.tscript3r.petclinic.services.map;

import org.springframework.stereotype.Service;
import pl.tscript3r.petclinic.models.PetType;
import pl.tscript3r.petclinic.services.PetTypeService;

import java.util.Set;

@Service
public class PetTypeServiceMap extends AbstractServiceMap<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType petType) {
        super.delete(petType);
    }

    @Override
    public PetType save(PetType petType) {
        return super.save(petType);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

}
