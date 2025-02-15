CREATE KEYSPACE IF NOT EXISTS my_keyspace WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE my_keyspace;

CREATE TYPE IF NOT EXISTS address (
                                      street TEXT,
                                      city TEXT,
                                      country TEXT
                                  );

CREATE TABLE IF NOT EXISTS users (
                                     id UUID PRIMARY KEY,
                                     name TEXT,
                                     email TEXT,
                                     address FROZEN<address>
);