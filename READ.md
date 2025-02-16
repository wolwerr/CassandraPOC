# Como rodar o projeto

Criar um container do Cassandra, com o comando: docker run --name cassandra -d -p 9042:9042 cassandra:latest

Entrar no container do Cassandra, digite: docker exec -it cassandra cqlsh

Criar o namespace com o comando:
CREATE KEYSPACE IF NOT EXISTS my_keyspace WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

Entre no my_keyspace com o comando: use my_keyspace;

Criar as tabelas users e address e o type phone com os comandos:
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


Verifique se criou as tabelas:
DESCRIBE tables;
DESCRIBE TYPE address;

