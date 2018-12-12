package pl.tscript3r.petclinic.boootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.tscript3r.petclinic.model.Owner;
import pl.tscript3r.petclinic.model.Vet;
import pl.tscript3r.petclinic.services.OwnerService;
import pl.tscript3r.petclinic.services.VetService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner0 = new Owner();
        owner0.setId(1L);
        owner0.setFirstName("Michael");
        owner0.setLastName("Weston");
        ownerService.save(owner0);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glenanne");
        ownerService.save(owner1);

        logger.info("Loaded owners..");

        Vet vet0 = new Vet();
        vet0.setId(1L);
        vet0.setFirstName("Sam");
        vet0.setLastName("Axe");
        vetService.save(vet0);

        Vet vet1 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Jessie");
        vet1.setLastName("Porter");
        vetService.save(vet1);

        logger.info("Loaded vets..");
    }

}
