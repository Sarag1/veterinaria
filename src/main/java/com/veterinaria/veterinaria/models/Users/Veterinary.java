package com.veterinaria.veterinaria.models.Users;
import com.veterinaria.veterinaria.dao.VeterinaryRepository;

public class Veterinary extends User{
    public Veterinary(String name, String cedula, String age, String gender, String email, String phone) {
        super(name, cedula, age, gender, email, phone);
    }
}
