package com.koper.petclinic.bootstrap;

import com.koper.petclinic.model.Owner;
import com.koper.petclinic.model.Pet;
import com.koper.petclinic.model.PetType;
import com.koper.petclinic.model.Vet;
import com.koper.petclinic.services.OwnerService;
import com.koper.petclinic.services.PetTypeService;
import com.koper.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Idan");
        owner1.setLastName("Koper");
        owner1.setAddress("2/2 Ustion");
        owner1.setCity("San Diego");
        owner1.setTelephone("999-444-213");

        Pet idansPet = new Pet();
        idansPet.setPetType(saveDogPetType);
        idansPet.setOwner(owner1);
        idansPet.setBirthDate(LocalDate.now());
        idansPet.setName("Joh");
        owner1.getPets().add(idansPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Miky");
        owner2.setLastName("Share");
        owner2.setAddress(" 4/4 Holyland");
        owner2.setCity("Los Angeles");
        owner2.setTelephone("000-222-111");

        Pet mikysPet = new Pet();
        mikysPet.setPetType(saveCatPetType);
        mikysPet.setOwner(owner2);
        mikysPet.setBirthDate(LocalDate.now());
        mikysPet.setName("Flora");
        owner2.getPets().add(mikysPet);
        ownerService.save(owner2);

        System.out.println("Load Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Roy");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Weathny");
        vet2.setLastName("Axim");

        vetService.save(vet2);

        System.out.println("Load Vets.....");
    }
}
