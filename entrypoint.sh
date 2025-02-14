#!/bin/sh
cassandra -R &  # Inicia o Cassandra em background
sleep 30  # Aguarda a inicialização
cqlsh -f /init.cql  # Executa o script de inicialização
tail -f /dev/null  # Mantém o container rodando
