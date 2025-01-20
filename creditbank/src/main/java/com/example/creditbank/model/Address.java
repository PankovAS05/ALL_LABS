package com.example.creditbank.model;

public class Address {
    private Long id;
    private String street;
    private String city;
    private String zipCode;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // Метод для получения полного адреса
    public String getFullAddress() {
        return street + ", " + city + ", " + zipCode;
    }
}
