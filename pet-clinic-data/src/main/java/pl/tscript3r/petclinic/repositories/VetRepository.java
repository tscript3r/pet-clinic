package pl.tscript3r.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.tscript3r.petclinic.models.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
