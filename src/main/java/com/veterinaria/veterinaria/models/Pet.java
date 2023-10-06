package com.veterinaria.veterinaria.models;

public class Pet {
    String name;
    String age;
    String gender;
    String emergencyContact;


    public Pet(String name, String age, String gender, String emergencyContact) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.emergencyContact = emergencyContact;
    }


    public Pet() {
        this.name = "";
        this.age = "";
        this.gender = "";
        this.emergencyContact = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}
