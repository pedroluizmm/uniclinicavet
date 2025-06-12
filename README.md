# Sistema de Gerenciamento de Clínica Veterinária

Este projeto oferece uma arquitetura inicial em Java para gerenciar tutores, animais, consultas e exames. A camada de persistência é feita com MySQL via JDBC.

A configuração de acesso ao banco é lida de variáveis de ambiente. Crie um arquivo `.env` na raiz com as chaves `DB_URL`, `DB_USER` e `DB_PASS` ou defina-as no seu sistema.

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

## Configuração do Banco de Dados

Copie o arquivo `.env.example` para `.env` e ajuste as variáveis `DB_URL`, `DB_USER` e `DB_PASS` de acordo com o seu ambiente de MySQL. Esses valores também podem ser definidos como variáveis de ambiente do sistema.

## Compilação
Utilize o JDK (versão 17 ou superior) para compilar manualmente os arquivos fonte.
Para rodar somente a aplicação de console, compile todas as classes Java
incluindo as dependências (ex.: usando Maven para copiar os jars):

```bash
javac -cp "target/dependency/*" -d out $(find src/main/java -name '*.java')
java -cp "target/dependency/*:out" com.uniclinica.controller.App
```

Para abrir a interface Swing com um pequeno formulário de agendamento basta executar a classe `SwingApp`:

```bash
javac -cp "target/dependency/*" -d out $(find src/main/java -name '*.java')
java -cp "target/dependency/*:out" com.uniclinica.controller.SwingApp
```

### Execução rápida com scripts

O repositório inclui scripts Bash que utilizam o Maven para compilar e executar o projeto:

```bash
./run.sh            # executa a aplicação de console
./run_swing.sh      # abre a interface Swing
```

### Execução rápida com Maven

Abra o terminal do IntelliJ e utilize o Maven para compilar e executar o projeto.
Os principais comandos são:

```bash
# Executar a aplicação de console
mvn exec:java

# Abrir a interface Swing
mvn exec:java -Dexec.mainClass=com.uniclinica.controller.SwingApp

```

O IntelliJ detecta automaticamente o projeto Maven, permitindo rodar os comandos
acima no terminal integrado ou criar configurações de execução a partir dos
objetivos `exec:java`.


### Executar interface Swing manualmente

Caso deseje rodar a interface gráfica sem o script, compile e execute a classe `SwingApp`:

```bash
javac -cp "target/dependency/*" -d out $(find src/main/java -name '*.java')
java -cp "target/dependency/*:out" com.uniclinica.controller.SwingApp
```

Ao executar, uma janela exibindo um formulário de agendamento de consultas e exames será apresentada.

## Próximos Passos
1. Implementar as classes de DAO utilizando JDBC.
2. Expandir a interface em Swing.
