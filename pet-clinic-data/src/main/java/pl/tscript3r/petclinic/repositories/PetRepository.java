package pl.tscript3r.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.tscript3r.petclinic.models.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
