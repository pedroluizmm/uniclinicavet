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
Um exemplo simples de compilação via linha de comando é:

```bash
javac -d out $(find src/main/java -name '*.java')
```

Depois da compilação, a aplicação principal pode ser executada com:

```bash
java -cp out com.uniclinica.controller.App
```

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
