package com.example.cassandra.models;

import com.datastax.oss.driver.api.core.data.UdtValue;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

@Component
@ReadingConverter
public class UdtValueToAddressConverter implements Converter<UdtValue, Address> {

    @Override
    public Address convert(UdtValue source) {
        Address address = new Address();
        address.setStreet(source.getString("street"));
        address.setCity(source.getString("city"));
        address.setCountry(source.getString("country"));
        return address;
    }
}
