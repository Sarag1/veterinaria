package com.veterinaria.veterinaria.models.Users;

public class Admin {
    private String name;
    private String cedula;
    private String password;

    public Admin(String name, String cedula, String password) {
        this.name = name;
        this.cedula = cedula;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getCedula() {
        return cedula;
    }

    public String getPassword() {
        return password;
    }
}
