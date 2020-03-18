package com.koper.petclinic.services;

import com.koper.petclinic.model.Owner;
import com.koper.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById (Long id);

    Pet save(Owner owner);

    Set<Pet> findAll();
}
