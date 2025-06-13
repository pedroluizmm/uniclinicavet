#!/bin/bash
set -e

# Abre a interface Swing usando Maven para incluir as dependências.
mvn -q exec:java -Dexec.mainClass=com.uniclinica.controller.SwingApp
