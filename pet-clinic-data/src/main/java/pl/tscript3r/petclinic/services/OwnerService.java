package pl.tscript3r.petclinic.services;

import pl.tscript3r.petclinic.models.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);

}
