package com.veterinaria.veterinaria.models.Users;

public class Seller extends User {
    private String enterpriseName;


    public Seller(String name, String cedula, String age, String gender, String email, String phone, String enterpriseName) {
        super(name, cedula, age, gender, email, phone);
        this.enterpriseName = enterpriseName;
    }

    public Seller() {
        super();
        this.enterpriseName = "";
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
}