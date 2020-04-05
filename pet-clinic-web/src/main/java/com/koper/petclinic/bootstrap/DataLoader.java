package com.koper.petclinic.bootstrap;

import com.koper.petclinic.model.*;
import com.koper.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;


    //Injected By Constructor
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty rediology = new Specialty();
        rediology.setDescription("Rediology");
        Specialty savedRediology = specialtyService.save(rediology);

        Specialty surgery = new Specialty();
        rediology.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        rediology.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Idan");
        owner1.setLastName("Koper");
        owner1.setAddress("2/2 Ustion");
        owner1.setCity("San Diego");
        owner1.setTelephone("999-444-213");

        Pet idansPet = new Pet();
        idansPet.setPetType(savedDogPetType);
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
        mikysPet.setPetType(savedCatPetType);
        mikysPet.setOwner(owner2);
        mikysPet.setBirthDate(LocalDate.now());
        mikysPet.setName("Flora");
        owner2.getPets().add(mikysPet);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(idansPet);
        catVisit.setLocalDate(LocalDate.now());
        catVisit.setDescription("National Park");
        visitService.save(catVisit);


        System.out.println("Load Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Roy");
        vet1.getSpecialities().add(savedRediology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Weathny");
        vet2.setLastName("Axim");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Load Vets.....");
    }
}
