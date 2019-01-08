package pl.tscript3r.petclinic.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.tscript3r.petclinic.models.*;
import pl.tscript3r.petclinic.services.*;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;
    private final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                           SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(petTypeService.findAll().size() == 0)
            loadData();

    }

    private void loadData() {

        logger.warn("Loading bootstrap data");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality radiologySaved = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality surgerySaved = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality dentistrySaved = specialityService.save(dentistry);

        logger.info("Loaded speciality types");

        PetType dogType = new PetType();
        dogType.setName("Dog");
        petTypeService.save(dogType);

        PetType catType = new PetType();
        catType.setName("Cat");
        petTypeService.save(catType);

        logger.info("Loaded pet types");

        Owner michael = new Owner();
        michael.setFirstName("Michael");
        michael.setLastName("Weston");
        michael.setAddress("Wyszyńskiego 213 / 23");
        michael.setCity("Wrocław");
        michael.setTelephone("00487301233112");

        Pet sabaDog = new Pet();
        sabaDog.setName("Saba");
        sabaDog.setOwner(michael);
        sabaDog.setPetType(dogType);
        sabaDog.setBirthDate(LocalDate.now());

        michael.getPets().add(sabaDog);
        ownerService.save(michael);

        Visit visit = new Visit();
        visit.setPet(sabaDog);
        visit.setDate(LocalDate.now());
        visit.setDescription("Sneezy Kitty");
        visitService.save(visit);

        Owner fiona = new Owner();
        fiona.setFirstName("Fiona");
        fiona.setLastName("Glenanne");
        fiona.setAddress("Grunwaldzka 76 / 5");
        fiona.setCity("Wrocław");
        fiona.setTelephone("00487302135412");

        Pet mrauCat = new Pet();
        mrauCat.setName("Mrau");
        mrauCat.setOwner(fiona);
        mrauCat.setPetType(catType);
        mrauCat.setBirthDate(LocalDate.now());

        fiona.getPets().add(mrauCat);
        ownerService.save(fiona);

        logger.info("Loaded owners & their pets");

        Vet vet0 = new Vet();
        vet0.setFirstName("Sam");
        vet0.setLastName("Axe");
        vet0.getSpecialities().add(radiologySaved);
        vet0.getSpecialities().add(surgerySaved);
        vetService.save(vet0);

        Vet vet1 = new Vet();
        vet1.setFirstName("Jessie");
        vet1.setLastName("Porter");
        vet1.getSpecialities().add(dentistry);
        vetService.save(vet1);

        logger.info("Loaded vets & their specialities");
    }

}
