# Sistema de Gerenciamento de Clínica Veterinária

Este projeto oferece uma arquitetura inicial em Java para gerenciar tutores, animais, consultas e exames. A camada de persistência será feita com MySQL via JDBC, mas a implementação dos acessos ao banco ainda não faz parte deste repositório.

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

## Próximos Passos
1. Implementar as classes de DAO utilizando JDBC.
2. Criar o schema MySQL e ajustar o `DBConnection` para usar as variáveis de ambiente `DB_USER` e `DB_PASS`.
3. Construir a interface em JavaFX ou Swing.
