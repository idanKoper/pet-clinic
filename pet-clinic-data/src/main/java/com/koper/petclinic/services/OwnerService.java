package com.koper.petclinic.services;

import com.koper.petclinic.model.Owner;

public interface OwnerService  extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

}
