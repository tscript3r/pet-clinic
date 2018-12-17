package pl.tscript3r.petclinic.boootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.tscript3r.petclinic.model.Owner;
import pl.tscript3r.petclinic.model.Pet;
import pl.tscript3r.petclinic.model.PetType;
import pl.tscript3r.petclinic.model.Vet;
import pl.tscript3r.petclinic.services.OwnerService;
import pl.tscript3r.petclinic.services.PetTypeService;
import pl.tscript3r.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType pt0 = new PetType();
        pt0.setName("Dog");
        petTypeService.save(pt0);

        PetType pt1 = new PetType();
        pt0.setName("Cat");
        petTypeService.save(pt0);

        logger.info("Loaded pet types");

        Owner owner0 = new Owner();
        owner0.setFirstName("Michael");
        owner0.setLastName("Weston");
        owner0.setAddress("Wyszyńskiego 213 / 23");
        owner0.setCity("Wrocław");
        owner0.setTelephone("00487301233112");

        Pet owner0Pet0 = new Pet();
        owner0Pet0.setName("Saba");
        owner0Pet0.setOwner(owner0);
        owner0Pet0.setPetType(pt0);
        owner0Pet0.setBirthDate(LocalDate.now());

        owner0.getPets().add(owner0Pet0);
        ownerService.save(owner0);

        Owner owner1 = new Owner();
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glenanne");
        owner1.setAddress("Grunwaldzka 76 / 5");
        owner1.setCity("Wrocław");
        owner1.setTelephone("00487302135412");

        Pet owner1Pet0 = new Pet();
        owner1Pet0.setName("Mrau");
        owner1Pet0.setOwner(owner1);
        owner1Pet0.setPetType(pt1);
        owner1Pet0.setBirthDate(LocalDate.now());

        owner1.getPets().add(owner1Pet0);
        ownerService.save(owner1);

        logger.info("Loaded owners & their pets");

        Vet vet0 = new Vet();
        vet0.setFirstName("Sam");
        vet0.setLastName("Axe");
        vetService.save(vet0);

        Vet vet1 = new Vet();
        vet1.setFirstName("Jessie");
        vet1.setLastName("Porter");
        vetService.save(vet1);

        logger.info("Loaded vets");

    }

}
