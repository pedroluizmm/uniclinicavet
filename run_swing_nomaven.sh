#!/bin/bash
set -e

# Ajusta separador do classpath conforme o sistema operacional
CP_SEP=":"
case "$(uname -s)" in
  MINGW*|MSYS*|CYGWIN*) CP_SEP=";" ;;
  *) CP_SEP=":" ;;
esac

JAR_DIR="lib"
DOTENV_JAR="dotenv-java-3.2.0.jar"
DOTENV_PATH="$JAR_DIR/$DOTENV_JAR"
DOTENV_URL="https://repo1.maven.org/maven2/io/github/cdimascio/dotenv-java/3.2.0/$DOTENV_JAR"

# Driver JDBC do MySQL
MYSQL_JAR="mysql-connector-java-8.0.29.jar"
MYSQL_PATH="$JAR_DIR/$MYSQL_JAR"
MYSQL_URL="https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.29/$MYSQL_JAR"

mkdir -p "$JAR_DIR"

if [ ! -f "$DOTENV_PATH" ]; then
  echo "Baixando dependencia $DOTENV_JAR..."
  curl -L -o "$DOTENV_PATH" "$DOTENV_URL"
fi

if [ ! -f "$MYSQL_PATH" ]; then
  echo "Baixando dependencia $MYSQL_JAR..."
  curl -L -o "$MYSQL_PATH" "$MYSQL_URL"
fi

mkdir -p out
echo "Compilando fontes..."
javac -cp "$JAR_DIR/*" -d out $(find src/main/java -name '*.java')

echo "Iniciando aplicativo Swing..."
java -cp "$JAR_DIR/*${CP_SEP}out" com.uniclinica.controller.SwingApp

# Em ambientes Windows, mantenha a janela aberta para o usuário ver mensagens
case "$(uname -s)" in
  MINGW*|MSYS*|CYGWIN*) read -rp "Pressione Enter para sair" _ ;;
esac
