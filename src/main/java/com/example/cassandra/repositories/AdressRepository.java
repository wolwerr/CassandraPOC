package com.example.cassandra.repositories;

import com.example.cassandra.models.Address;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface AdressRepository extends CassandraRepository<Address, UUID> {
}
