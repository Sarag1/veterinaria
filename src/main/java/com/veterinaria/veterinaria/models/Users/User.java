package com.veterinaria.veterinaria.models.Users;

public abstract class User {
    String name;
    String cedula;
    String age;
    String gender;
    String email;
    String phone;


    public User(String name, String cedula, String age, String gender, String email, String phone) {
        this.name = name;
        this.cedula = cedula;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public User(){
        this.name = "";
        this.cedula = "";
        this.age = "";
        this.gender = "";
        this.email = "";
        this.phone = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        if(age.matches("[0-9]+" )) {
            this.age = age;
        } else {
            this.age = "0";
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
