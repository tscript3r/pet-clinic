package pl.tscript3r.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.tscript3r.petclinic.models.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
