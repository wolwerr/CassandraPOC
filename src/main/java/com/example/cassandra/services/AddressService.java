package com.example.cassandra.services;

import com.example.cassandra.models.Address;
import com.example.cassandra.repositories.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AdressRepository addressRepository;

    public Address saveAddress(Address address) {
        address.setId(UUID.randomUUID());
        return addressRepository.save(address);
    }

    public Optional<Address> getAddressById(UUID id) {
        return addressRepository.findById(id);
    }

    public Iterable<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public void deleteAddress(UUID id) {
        addressRepository.deleteById(id);
    }
}