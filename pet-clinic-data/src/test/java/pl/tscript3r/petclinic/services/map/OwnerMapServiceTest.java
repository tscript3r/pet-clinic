package pl.tscript3r.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.tscript3r.petclinic.models.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    final Long ownerId = 1L;
    final String lastName = "Smith";

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(2L).build();
        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());

    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(owner.getId(), ownerId);
    }

    @Test
    void findByLastName() {
        Owner smith = ownerMapService.findByLastName(lastName);
        assertNotNull(smith);
        assertEquals(smith.getId(), ownerId);
    }

    @Test
    void findByLastNameNotFound() {
        Owner nullOwner = ownerMapService.findByLastName("foo");
        assertNull(nullOwner);
    }
}