#!/bin/bash
set -e

if [ -z "$JAVAFX_LIB" ]; then
  echo "Set JAVAFX_LIB to the JavaFX lib directory" >&2
  exit 1
fi

mkdir -p out
javac --module-path "$JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml \
      -d out $(find src/main/java -name '*.java')

java --module-path "$JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml \
     -cp out com.uniclinica.controller.JavaFXApp
