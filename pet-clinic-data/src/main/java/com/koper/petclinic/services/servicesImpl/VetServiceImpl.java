package com.koper.petclinic.services.servicesImpl;

import com.koper.petclinic.model.Vet;
import com.koper.petclinic.repositories.VetRepository;
import com.koper.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("servicesImpl")
public class VetServiceImpl implements VetService {

    @Autowired
    private VetRepository vetRepository;

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deletById(Long id) {
        vetRepository.deleteById(id);
    }
}
