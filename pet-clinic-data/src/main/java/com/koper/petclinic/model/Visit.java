package com.koper.petclinic.model;

import java.time.LocalDate;

public class Visit extends BaseEntity{

    private LocalDate localDate;
    private String description;
    private Pet Pet;

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.koper.petclinic.model.Pet getPet() {
        return Pet;
    }

    public void setPet(com.koper.petclinic.model.Pet pet) {
        Pet = pet;
    }
}
