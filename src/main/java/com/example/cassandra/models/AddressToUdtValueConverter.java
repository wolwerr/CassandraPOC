package com.example.cassandra.models;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.data.UdtValue;
import com.datastax.oss.driver.api.core.type.UserDefinedType;
import org.springframework.core.convert.converter.Converter;

public class AddressToUdtValueConverter implements Converter<Address, UdtValue> {
    private final UserDefinedType addressUdt;

    public AddressToUdtValueConverter(CqlSession session) {
        this.addressUdt = session.getMetadata().getKeyspace("my_keyspace")
                .flatMap(ks -> ks.getUserDefinedType("address")).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public UdtValue convert(Address source) {
        return addressUdt.newValue()
                .setString("street", source.getStreet())
                .setString("city", source.getCity())
                .setString("country", source.getCountry());
    }
}