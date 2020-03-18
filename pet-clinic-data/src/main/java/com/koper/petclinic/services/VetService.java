package com.koper.petclinic.services;

import com.koper.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById (Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();

}
