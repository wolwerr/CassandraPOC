package com.example.cassandra.Config;

import com.datastax.oss.driver.api.core.CqlSession;
import com.example.cassandra.models.AddressToUdtValueConverter;
import com.example.cassandra.models.UdtValueToAddressConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraCustomConversions;

import java.util.Arrays;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "my_keyspace";
    }

    @Bean
    @Primary
    public CqlSession cqlSession() {
        return CqlSession.builder()
                .withKeyspace(getKeyspaceName())
                .build();
    }

    @Bean
    public CassandraTemplate cassandraTemplate(CqlSession cqlSession) {
        return new CassandraTemplate(cqlSession);
    }

    @Bean
    @Override
    public CassandraCustomConversions customConversions() {
        return new CassandraCustomConversions(Arrays.asList(
                new AddressToUdtValueConverter(cqlSession()),
                new UdtValueToAddressConverter()
        ));
    }
}