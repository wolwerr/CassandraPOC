CREATE KEYSPACE IF NOT EXISTS my_keyspace WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE my_keyspace;

CREATE TABLE IF NOT EXISTS address (
                                       id UUID PRIMARY KEY,
                                       street TEXT,
                                       city TEXT,
                                       country TEXT,
                                       user_id UUID
);

CREATE TYPE IF NOT EXISTS phone (
                                    phoneNumber TEXT,
                                    phoneType TEXT
                                );

CREATE TABLE IF NOT EXISTS users (
                                     id UUID PRIMARY KEY,
                                     name TEXT,
                                     age int,
                                     email TEXT,
                                     address_id UUID,
                                     phones list<frozen<phone>>
);

