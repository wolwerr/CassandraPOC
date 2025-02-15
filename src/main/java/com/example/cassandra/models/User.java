package com.example.cassandra.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table("users")
public class User {
    @PrimaryKey
    private UUID id;
    private String name;
    private int age;
    private String email;
    private UUID address_id;

    @CassandraType(type = CassandraType.Name.LIST,
            typeArguments = CassandraType.Name.UDT,
            userTypeName = "phone")
    private List<Phone> phones;
}