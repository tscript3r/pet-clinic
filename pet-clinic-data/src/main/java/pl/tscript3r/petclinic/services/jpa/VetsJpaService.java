package pl.tscript3r.petclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.tscript3r.petclinic.models.Vet;
import pl.tscript3r.petclinic.repositories.VetRepository;
import pl.tscript3r.petclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VetsJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetsJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets :: add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
