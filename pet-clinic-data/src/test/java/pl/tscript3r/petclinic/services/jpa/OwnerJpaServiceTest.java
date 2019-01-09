package pl.tscript3r.petclinic.services.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.tscript3r.petclinic.models.Owner;
import pl.tscript3r.petclinic.repositories.OwnerRepository;
import pl.tscript3r.petclinic.repositories.PetRepository;
import pl.tscript3r.petclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    final String LAST_NAME = "Smith";
    final Long ID = 1L;

    Owner owner;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJpaService ownerJpaService;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner returnedOwner = ownerJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, returnedOwner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(owner);
        ownerSet.add(Owner.builder().id(ID + 1L).build());
        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> returnedOwnersSet = ownerJpaService.findAll();

        assertNotNull(returnedOwnersSet);
        assertEquals(returnedOwnersSet.size(), ownerSet.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));
        Owner returnedOwner = ownerJpaService.findById(ID);

        assertNotNull(returnedOwner);
        assertEquals(ID, returnedOwner.getId());
        verify(ownerRepository).findById(ID);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        Owner returnedOwner = ownerJpaService.findById(ID);

        assertNull(returnedOwner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner returnedOwner = ownerJpaService.save(owner);

        assertNotNull(returnedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerJpaService.delete(owner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerJpaService.deleteById(ID);
        verify(ownerRepository).deleteById(ID);
    }
}