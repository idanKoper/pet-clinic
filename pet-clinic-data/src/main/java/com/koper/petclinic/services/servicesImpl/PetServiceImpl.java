package com.koper.petclinic.services.servicesImpl;

import com.koper.petclinic.model.Pet;
import com.koper.petclinic.repositories.PetRepository;
import com.koper.petclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("servicesImpl")
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;


    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deletById(Long id) {
        petRepository.deleteById(id);
    }
}
