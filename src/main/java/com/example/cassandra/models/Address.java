package com.example.cassandra.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;


import java.util.UUID;

@Getter
@Setter
public class Address {
    @PrimaryKey
    private UUID id;
    private String street;
    private String city;
    private String country;
}