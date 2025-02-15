package com.example.cassandra.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Getter
@Setter
@UserDefinedType("phone")
public class Phone {

    private String phoneType;
    private String phoneNumber;

}