#!/bin/bash

echo "Waiting for Cassandra..."

until cqlsh cassandra 9042 -e "describe keyspaces"
do
    sleep 5
done

echo "Creating schema..."

cqlsh cassandra 9042 -f /scripts/schema.cql

echo "Loading sample data..."

cqlsh cassandra 9042 -f /scripts/data.cql

echo "Database initialized."