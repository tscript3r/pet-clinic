package pl.tscript3r.petclinic.services;

import pl.tscript3r.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
