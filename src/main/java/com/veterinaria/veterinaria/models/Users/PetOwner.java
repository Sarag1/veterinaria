package com.veterinaria.veterinaria.models.Users;

public class PetOwner extends User{
    private String petId;
    public PetOwner(String name, String cedula, String age, String gender, String email, String phone, String petId) {
        super(name, cedula, age, gender, email, phone);
        this.petId = petId;
    }

    public PetOwner(){
        super();
        this.petId = "";
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }
}
