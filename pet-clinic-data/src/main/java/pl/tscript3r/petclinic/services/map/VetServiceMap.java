package pl.tscript3r.petclinic.services.map;

import org.springframework.stereotype.Service;
import pl.tscript3r.petclinic.models.Speciality;
import pl.tscript3r.petclinic.models.Vet;
import pl.tscript3r.petclinic.services.SpecialityService;
import pl.tscript3r.petclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        if(vet != null) {

            // Making sure, that any used speciality has his own id, if not - filling it by using Hibernate
            vet.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });

        } else
            return null;
        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

}
