#!/bin/bash
set -e

JAR_DIR="lib"
JAR_NAME="dotenv-java-3.2.0.jar"
JAR_PATH="$JAR_DIR/$JAR_NAME"
JAR_URL="https://repo1.maven.org/maven2/io/github/cdimascio/dotenv-java/3.2.0/$JAR_NAME"

mkdir -p "$JAR_DIR"
if [ ! -f "$JAR_PATH" ]; then
  echo "Baixando dependencia $JAR_NAME..."
  curl -L -o "$JAR_PATH" "$JAR_URL"
fi

mkdir -p out
echo "Compilando fontes..."
javac -cp "$JAR_DIR/*" -d out $(find src/main/java -name '*.java')

echo "Iniciando aplicativo Swing..."
java -cp "$JAR_DIR/*:out" com.uniclinica.controller.SwingApp
