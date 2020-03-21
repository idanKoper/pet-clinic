package com.koper.petclinic.bootstrap;

import com.koper.petclinic.model.Owner;
import com.koper.petclinic.model.Vet;
import com.koper.petclinic.services.OwnerService;
import com.koper.petclinic.services.VetService;
import com.koper.petclinic.services.map.OwnerServiceMap;
import com.koper.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Idan");
        owner1.setLastName("Koper");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Michael");
        owner2.setLastName("Kami");

        ownerService.save(owner2);

        System.out.println("Load Owners.....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Roy");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Weathny");
        vet2.setLastName("Axim");

        vetService.save(vet2);

        System.out.println("Load Vets.....");
    }
}
