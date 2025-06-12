# Sistema de Gerenciamento de Clínica Veterinária

Este projeto oferece uma arquitetura inicial em Java para gerenciar tutores, animais, consultas e exames. A camada de persistência é feita com MySQL via JDBC.

A classe `DBConnection` possui os dados de acesso ao banco de dados definidos diretamente no código. Ajuste as constantes `URL`, `USER` e `PASS` conforme a sua instalação do MySQL.

## Estrutura de Pastas
```
src/
  main/
    java/
      com/uniclinica/
        model/       # Entidades simples (POJOs)
        dao/         # DAOs com JDBC (a implementar)
        service/     # Regras de negócio
        controller/  # Ponto de entrada e controladores
        util/        # Utilidades (ex: conexões)
    resources/       # Recursos adicionais
```

## Compilação
Utilize o JDK (versão 17 ou superior) para compilar manualmente os arquivos fonte.
Para rodar somente a aplicação de console, compile excluindo a classe JavaFX:

```bash
javac -d out $(find src/main/java -name '*.java' ! -name 'JavaFXApp.java')
java -cp out com.uniclinica.controller.App
```

Para a interface JavaFX é necessário informar as bibliotecas do JavaFX:

```bash
javac --module-path "$JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml \
      -d out $(find src/main/java -name '*.java')

java --module-path "$JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml \
     -cp out com.uniclinica.controller.JavaFXApp
```

### Execução rápida com scripts

O repositório inclui scripts Bash para facilitar a compilação e execução:

```bash
./run.sh                       # compila e roda a aplicação de console
JAVAFX_LIB=/caminho/javafx/lib ./run_javafx.sh  # compila e roda o JavaFX
```

### Execução rápida com Maven

Abra o terminal do IntelliJ e utilize o Maven para compilar e executar o projeto.
Os principais comandos são:

```bash
# Executar a aplicação de console
mvn exec:java

# Abrir a interface JavaFX
mvn javafx:run
```

O IntelliJ detecta automaticamente o projeto Maven, permitindo rodar os comandos
acima no terminal integrado ou criar configurações de execução a partir dos
objetivos `exec:java` e `javafx:run`.

### Executar interface JavaFX

Para abrir a interface gráfica básica é necessário ter as bibliotecas do JavaFX disponíveis. Após baixar os JARs, a execução pode ser feita da seguinte forma (ajuste o caminho conforme sua instalação):

```bash
java --module-path /caminho/para/javafx/lib \
     --add-modules javafx.controls,javafx.fxml \
     -cp out com.uniclinica.controller.JavaFXApp
```

Uma janela simples será exibida demonstrando a integração do projeto com JavaFX.

## Próximos Passos
1. Implementar as classes de DAO utilizando JDBC.
2. Expandir a interface em JavaFX.
