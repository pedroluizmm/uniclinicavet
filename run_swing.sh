#!/bin/bash
set -e
mkdir -p out
javac -d out $(find src/main/java -name '*.java')
java -cp out com.uniclinica.controller.SwingApp
