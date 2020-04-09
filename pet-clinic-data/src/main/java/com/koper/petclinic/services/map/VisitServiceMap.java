package com.koper.petclinic.services.map;

import com.koper.petclinic.model.Visit;
import com.koper.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitServiceMap extends AbstractMapService<Visit,Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit visit) {
        super.deleteByObject(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.pet() == null || visit.pet().getOwner() == null ||
                visit.pet().getId() == null || visit.pet().getOwner().getId() == null)
            throw new RuntimeException("Invalid Visit");
        else{
            return super.save(visit);
        }
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
