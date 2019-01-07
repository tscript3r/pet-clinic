package pl.tscript3r.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.tscript3r.petclinic.models.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
