package pl.tscript3r.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.tscript3r.petclinic.models.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
