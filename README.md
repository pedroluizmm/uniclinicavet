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
O projeto utiliza Maven. Para compilar:

```bash
mvn clean package
```

A geração do JAR criará o artefato em `target/`. A aplicação principal está no pacote `com.uniclinica.controller`.

### Executar interface JavaFX

Para abrir a interface gráfica básica, utilize o plugin JavaFX:

```bash
mvn javafx:run
```

Uma janela simples será exibida demonstrando a integração do projeto com JavaFX.

## Próximos Passos
1. Implementar as classes de DAO utilizando JDBC.
2. Expandir a interface em JavaFX.
