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
Se preferir dispensar o Maven, baixe a biblioteca `dotenv-java` para a pasta `lib/`
e a inclua no classpath:

```bash
curl -L -o lib/dotenv-java-3.2.0.jar \
  https://repo1.maven.org/maven2/io/github/cdimascio/dotenv-java/3.2.0/dotenv-java-3.2.0.jar
```

```bash
javac -cp "lib/*" -d out $(find src/main/java -name '*.java')

# use ';' instead of ':' on Windows

java -cp "lib/*:out" com.uniclinica.controller.App
```

Para abrir a interface Swing com um pequeno formulário de agendamento basta executar a classe `SwingApp`:

```bash
javac -cp "lib/*" -d out $(find src/main/java -name '*.java')

# use ';' instead of ':' on Windows

java -cp "lib/*:out" com.uniclinica.controller.SwingApp
```

### Execução rápida com scripts

O repositório inclui scripts Bash para facilitar a execução. Os arquivos `run.sh` e `run_swing.sh`

utilizam o Maven, enquanto `run_swing_nomaven.sh` baixa a dependência `dotenv-java` e roda a interface sem Maven.
Execute-os dentro de um terminal **Bash** (ex.: Git Bash no Windows) para evitar que a janela se feche imediatamente em caso de erro:


```bash
./run.sh                 # executa a aplicação de console (via Maven)
./run_swing.sh           # abre a interface Swing (via Maven)
./run_swing_nomaven.sh   # baixa o jar necessário e executa a interface sem Maven
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

Caso deseje rodar a interface gráfica sem Maven nem scripts, compile e execute a classe `SwingApp`:

```bash
javac -cp "lib/*" -d out $(find src/main/java -name '*.java')

# use ';' instead of ':' on Windows

java -cp "lib/*:out" com.uniclinica.controller.SwingApp
```

Ao executar, uma janela com duas abas será apresentada: **Agendamento**, que permite marcar consultas e exames, e **Admin**, onde é possível realizar operações de CRUD para tutores, animais, consultas e exames. Todas as ações utilizam um banco MySQL configurado via `.env`.

## Próximos Passos
1. Melhorar a validação de dados e a usabilidade da interface.
