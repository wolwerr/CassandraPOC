package com.example.cassandra.models;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("address")
public class Address {
    private String street;
    private String city;
    private String country;

    // Default constructor
    public Address() {}

    // Constructor with arguments
    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    // Getters and Setters
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}