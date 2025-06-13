#!/bin/bash
set -e

# Executa a aplicação de console utilizando Maven para resolver as dependências.
mvn -q exec:java
