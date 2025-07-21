package com.caglar.finalprojectaws.Controllers;

public class Person {

    private String first_name;
    private String sur_name;
    private String PPSN;
    private String gender;
    private String email;
    private String phone_number;
    private String address_line_one;
    private String address_line_two;
    private String city;
    private String eircode;
    private String date_of_birth;

    public Person() {
        //default Constructor
    }

    public Person(String first_name, String sur_name, String PPSN, String gender, String email, String phone_number, String address_line_one, String address_line_two,
            String city, String eircode, String date_of_birth) {
        this.first_name = first_name;
        this.sur_name = sur_name;
        this.PPSN = PPSN;
        this.gender = gender;
        this.email = email;
        this.phone_number = phone_number;
        this.address_line_one = address_line_one;
        this.address_line_two = address_line_two;
        this.city = city;
        this.eircode = eircode;
        this.date_of_birth = date_of_birth;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSur_name() {
        return sur_name;
    }

    public void setSur_name(String sur_name) {
        this.sur_name = sur_name;
    }

    public String getPPSN() {
        return PPSN;
    }

    public void setPPSN(String PPSN) {
        this.PPSN = PPSN;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress_line_one() {
        return address_line_one;
    }

    public void setAddress_line_one(String address_line_one) {
        this.address_line_one = address_line_one;
    }

    public String getAddress_line_two() {
        return address_line_two;
    }

    public void setAddress_line_two(String address_line_two) {
        this.address_line_two = address_line_two;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void displayInfo() {
        System.out.println("Person info: " + getFirst_name() + " " + getSur_name());
    }

}
