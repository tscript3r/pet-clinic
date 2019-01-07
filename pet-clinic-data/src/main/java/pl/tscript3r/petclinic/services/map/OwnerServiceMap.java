package pl.tscript3r.petclinic.services.map;

import org.springframework.stereotype.Service;
import pl.tscript3r.petclinic.models.Owner;
import pl.tscript3r.petclinic.models.Pet;
import pl.tscript3r.petclinic.services.OwnerService;
import pl.tscript3r.petclinic.services.PetService;
import pl.tscript3r.petclinic.services.PetTypeService;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractServiceMap<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {

        // Making sure, that any pet which belongs to this given owner has his PetType associated
        if(owner != null) {
            if(owner.getPets() != null){
                owner.getPets().forEach(pet -> {

                    if(pet.getPetType() != null)
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    else
                        throw new RuntimeException("Pet type is required");

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }

                });
            }
           return super.save(owner);
        } else
           return null;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        // TODO: Implement findByLastName function
        return null;
    }

}
